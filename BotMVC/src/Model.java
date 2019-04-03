import java.util.LinkedList;
import java.util.List;

import com.pengrad.telegrambot.model.Update;

public class Model implements Subject{
	
	private List<Observer> observers = new LinkedList<Observer>();
	
	private List<Objeto> objetos = new LinkedList<Objeto>();
	
	
	private static Model uniqueInstance;
	
	private Model(){}
	
	public static Model getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Model();
		}
		return uniqueInstance;
	}
	
	public void registerObserver(Observer observer){
		observers.add(observer);
	}
	
	public void notifyObservers(long chatId, String studentsData){
		for(Observer observer:observers){
			observer.update(chatId, studentsData);
		}
	}
	
	public void addObjeto(Objeto objeto){
		this.objetos.add(objeto);
	}
	
	
	public void searchObjeto(Update update){
		String ObjetoData = null;
		for(Objeto objeto: objetos){
			if(objeto.getCodigo().equals(update.message().text())){
				ObjetoData = objeto.getCodigo();
			}
		}
		
		if(ObjetoData != null){
			this.notifyObservers(update.message().chat().id(), ObjetoData);
		} else {
			this.notifyObservers(update.message().chat().id(), "Mercadoria não encontrada.");
		}
		
	}
		
	

}