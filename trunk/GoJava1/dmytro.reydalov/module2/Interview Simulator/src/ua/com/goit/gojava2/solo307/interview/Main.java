package ua.com.goit.gojava2.solo307.interview;

public class Main {
	public static void main(String[] args) {
		Interview interview = new Interview();
		Menu menu = new Menu();
		int choise = 1;
		while(choise != 0){
			menu.printMenu();
			choise = menu.readInt();
			menu.chooseOperation(choise, interview);
		}
	}
}
