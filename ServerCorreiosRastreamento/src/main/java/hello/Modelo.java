package hello;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Modelo {
	ObjectContainer Administrador = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/Administrador.db4o");
	

	public boolean addAdministrador(Administrador Administrador){
		if(isAdministradorUserAvailable(Administrador.getUsername())){
			
			this.Administrador.store(Administrador);
			this.Administrador.commit();
			
			return true;
		}
		
		return false;
	}	
	
	private boolean isAdministradorUserAvailable(String username) {
		Query query = Administrador.query();
		query.constrain(Administrador.class);
	    ObjectSet<Administrador> allAdministrador = query.execute();
	    
	    for(Administrador Administrador:allAdministrador){
	    	if(Administrador.getUsername().equals(username)) return false;
	    }
	    
	    return true;
	}
	
	/*
	 * //--------------------- USUARIOS --------------------- public boolean
	 * addUsuario(Usuario Usuario){ if(isUsuarioUserAvailable(Usuario.getEmail())){
	 * 
	 * this.Usuario.store(Usuario); this.Usuario.commit();
	 * 
	 * return true; }
	 * 
	 * return false; }
	 * 
	 * 
	 * private boolean isUsuarioUserAvailable(String email) { Query query =
	 * Usuario.query(); query.constrain(Usuario.class); ObjectSet<Usuario>
	 * allUsuario = query.execute();
	 * 
	 * for(Usuario Usuario:allUsuario){ if(Usuario.getEmail().equals(email)) return
	 * false; }
	 * 
	 * return true; }
	 */
	
}
