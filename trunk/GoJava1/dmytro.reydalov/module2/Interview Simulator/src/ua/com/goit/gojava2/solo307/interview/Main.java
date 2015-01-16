package ua.com.goit.gojava2.solo307.interview;

public class Main {
	public static void main(String[] args) {
		Interview myInterview = new Interview();
		Menu menu = new Menu();
		myInterview.fillQuestionList();
		int choise = 1;
		while(choise != 0){
			Menu.printMenu();
			choise = menu.ReadInt();
			Menu.chooseOperation(choise);
		}
	}
}
