package ua.com.goit.gojava.myshko;

public class Main {

	public static void main(String[] args) {

		DataManager dataManager = new DataManager();
		UserScreen userScreen = new UserScreen();
		
		TransactionsStore transactionsData = dataManager.readTransactionsStore();
				
		Menu m = new Menu(userScreen);
		m.show(transactionsData);
		
		dataManager.saveTransactionsStore(transactionsData);
		userScreen.close();	

	}

}