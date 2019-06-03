public class Main {

	
private static Model model;
	
	public static void main(String[] args) {

		model = Model.getInstance();
		initializeModel(model);
		View view = new View(model);
		model.registerObserver(view); //connection Model -> View
		view.receiveUsersMessages();

	}
	
	public static void initializeModel(Model model){
		model.addObjeto(new Objeto("a","OA160610789BR","Objeto entregue ao destinat�rio"));
	}
	/* Exemplo para utilizar apenas a Main sem o conceito de MVC
	public static void main(String[] args) {

		//Criação do objeto bot com as informações de acesso
		TelegramBot bot = TelegramBotAdapter.build("760008905:AAHpWKPBodLu-bE8p_foM6fkRhWORzk5DvM");

		//objeto responsável por receber as mensagens
		GetUpdatesResponse updatesResponse;
		//objeto responsável por gerenciar o envio de respostas
		SendResponse sendResponse;
		//objeto responsável por gerenciar o envio de ações do chat
		BaseResponse baseResponse;
		
		//controle de off-set, isto é, a partir deste ID será lido as mensagens pendentes na fila
		int m=0;
		
		//loop infinito pode ser alterado por algum timer de intervalo curto
		
		while (true){
		
			//executa comando no Telegram para obter as mensagens pendentes a partir de um off-set (limite inicial)
			updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(m));
			
			//lista de mensagens
			List<Update> updates = updatesResponse.updates();

			//análise de cada ação da mensagem
			
			for (Update update : updates) {
				
				//bot.execute(new SendMessage(update.message().chat().id(),"Ol� usu�rio este bot ir� te auxiliar no restreio de sua encomenda"));
				//atualização do off-set
				m = update.updateId()+1;
				
				System.out.println("Recebendo mensagem:"+ update.message().text());
				
				//envio de "Escrevendo" antes de enviar a resposta
				baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
				//verificação de ação de chat foi enviada com sucesso
				System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());
				
				//envio da mensagem de resposta
				sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"N�o entendi..."));
				//verificação de mensagem enviada com sucesso
				System.out.println("Mensagem Enviada?" +sendResponse.isOk());
				
			}

		}

	}*/

}
