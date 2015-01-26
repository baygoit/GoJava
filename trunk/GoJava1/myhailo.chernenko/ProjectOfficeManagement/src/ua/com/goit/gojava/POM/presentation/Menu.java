package ua.com.goit.gojava.POM.presentation;

import ua.com.goit.gojava.POM.persistence.DataManager;

class Menu {
	
	UserScreen userScreen;
	
	public Menu(UserScreen userScreen) {
		
		this.userScreen = userScreen;

	}

	private void processCommand(String command, DataManager dataManager) {
	
		if (command.contentEquals("-show")) {
			
			//userScreen.showDataObject(dataManager.getTransactionsStore());
			
		} else if (command.contentEquals("-showProjects")) {
			
			//userScreen.showDataObject(dataManager.getProjectMap());
			
		} else if (command.contentEquals("-showProjectsProfit")) {
			
			//userScreen.showDataObject(dataManager.getProjectsProfit());
			
		} else if (command.contentEquals("-showCostItems")) {
			
			//userScreen.showDataObject(dataManager.getCostItemMap());
			
		} else if (command.contentEquals("-update")) {
	
			//userScreen.updateDataObject(dataManager.getTransactionsStore(), dataManager);
		
		} else if (!command.isEmpty()) {
		
			userScreen.showString("Unknown command");
			
		}
		
	}
	
	public void show(DataManager dataManager) {

		userScreen.showString("Welcome to 'Project Office Management System'!");
		userScreen.showString("Type '-show' for view data;"+"\r\n"
								+ " '-update' for update data;"+"\r\n"
								+ " '-showProjects' for view projects list;"+"\r\n"
								+ " '-showCostItems' for view cost items list;"+"\r\n"
								+ " '-showProjectsProfit' for view projects profit list;"+"\r\n"
								+ "or press Enter for exit:");
		
		processCommand(userScreen.getString(), dataManager);
		
	}
	
}
