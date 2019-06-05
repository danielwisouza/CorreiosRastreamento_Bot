package hello;


import java.util.LinkedList;

import java.util.List;
import java.util.NoSuchElementException;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;


public class Modelo {
	ObjectContainer Usuario = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/Usuario.db4o");
	ObjectContainer Objeto = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/Objeto.db4o");
	
	
	public boolean addUsuario(Usuario usuario){

		try {
			this.Usuario.store(Usuario);
			this.Usuario.commit();
			
			return true;
		}
		catch (Exception ex){
			return false; 
		}

	}
	
	
	public boolean addObjeto(Objeto objeto){

		try {
			this.Objeto.store(Objeto);
			this.Objeto.commit();
			
			return true;
		}
		catch (Exception ex){
			return false; 
		}

	}
	
	
     public Objeto BuscaObjeto(String Codigo){
		
		
		Query query = Objeto.query();
		query.constrain(Usuario.class);
	    ObjectSet<Objeto> allObjeto = query.execute();
		
	    for(Objeto Objeto:allObjeto){
	    	if(Objeto.getCodigo()==Codigo){
	    		return Objeto;
	    	}
	    }
	    return null;
	}
     
     public List<Objeto> listarObjetos() {
 		
 		List<Objeto> listaObjeto = new LinkedList<Objeto>();
 		
 		Query query = Objeto.query();
 		query.constrain(Objeto.class);
 		ObjectSet<Objeto> allObjeto = query.execute();
 		
 	    for(Objeto objeto:allObjeto){
 	    	listaObjeto.add(objeto);
 	    }
 	    
 	    return listaObjeto;
 		

	}
     
     public Integer getNextCodeObjeto() {
 		List<Objeto> listaObjeto = listarObjetos();
 		
 		Integer cod = 0;
 		cod = listaObjeto
 	      .stream()
 	      .mapToInt(v -> v.getId())
 	      .max().orElseThrow(NoSuchElementException::new);
 		
 		return cod + 1;
 		
 	}
	
     
}
	

