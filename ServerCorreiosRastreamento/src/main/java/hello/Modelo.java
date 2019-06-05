package hello;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Modelo {
	ObjectContainer Usuario = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/Usuario.db4o");
	
	
	  boolean addUsuario(Usuario Usuario){ if(isUsuarioUserAvailable(Usuario.getEmail())){
	  
	  this.Usuario.store(Usuario); this.Usuario.commit();
	  
	  return true; }
	  
	  return false; }
	  
	  
	  private boolean isUsuarioUserAvailable(String email) { Query query =
	  Usuario.query(); query.constrain(Usuario.class); ObjectSet<Usuario>
	  allUsuario = query.execute();
	  
	  for(Usuario Usuario:allUsuario){ if(Usuario.getEmail().equals(email)) return
	  false; }
	  
	  return true; }
	 
	
}
