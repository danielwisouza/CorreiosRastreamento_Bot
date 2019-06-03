package hello;


import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class MainServer {
	
	final static Modelo modelo = new Modelo();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8090;
        }
        port(port);

        staticFileLocation("/static");
		
        Controller controller = new Controller(modelo); 
        
        inicializarDados();
		
    }
    
    public static void inicializarDados(){
    	//modelo.addAdministrador(new Administrador("daniel.souza", "12345"));
    }
}