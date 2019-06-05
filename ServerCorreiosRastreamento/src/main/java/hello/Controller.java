package hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;


public class Controller {
	
	private Modelo modelo;
	
	public Controller(Modelo store){
		this.modelo = store;
	}

	
	public void objetos() {
		
		get("/objetos", (req, res) -> {
			List<Objeto> listaObjetos = new LinkedList<Objeto>();
			listaObjetos = modelo.listarObjetos();
		    return new Gson().toJson(listaObjetos);
		});
		
		post("/objetos", (request, response) -> {
			
		    response.type("application/json");
		    Objeto objeto = new Gson().fromJson(request.body(), Objeto.class);
		    
		    Integer numeroObjeto = modelo.getNextCodeObjeto();
		    objeto.setId(numeroObjeto);
		    
		    Boolean ret = modelo.addObjeto(objeto);
		    
		    String json_str = "{\"success\":\""+ ret.toString() +"\"}";
		 
		    return new Gson().toJson(json_str);
		});
		
	}
	
}