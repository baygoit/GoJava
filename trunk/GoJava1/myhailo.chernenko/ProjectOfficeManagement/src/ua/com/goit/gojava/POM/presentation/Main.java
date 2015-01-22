package ua.com.goit.gojava.POM.presentation;

//import ua.com.goit.gojava.POM.dataModel.TransactionsStore;
import ua.com.goit.gojava.POM.persistence.DataManager;

public class Main {

	public static void main(String[] args) {

		DataManager dataManager = new DataManager();
		UserScreen userScreen = new UserScreen();
		
		Menu m = new Menu(userScreen);
		m.show(dataManager);
		
		dataManager.saveData();
		userScreen.close();	

	}

}