package ua.com.goit.gojava.POM.presentation;

import ua.com.goit.gojava.POM.dataModel.DataObject;

class Menu {
	
	UserScreen userScreen;
	
	public Menu(UserScreen userScreen) {
		
		this.userScreen = userScreen;

	}

	private void processCommand(String command, DataObject obj) {
	
		if (command.contentEquals("-show")) {
			
			userScreen.showDataObject(obj);
			
		} else if (command.contentEquals("-update")) {
	
			obj.update(userScreen);
		
		} else if (!command.isEmpty()) {
		
			userScreen.showString("Unknown command");
			
		}
		
	}
	
	public void show(DataObject obj) {

		userScreen.showString("Welcome to 'Project Office Management System'!");
		userScreen.showString("Type '-show' for view data, '-update' for update data or press Enter for exit:");
		
		processCommand(userScreen.getString(), obj);
		
	}
	
}
