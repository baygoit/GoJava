package ua.com.goit.gojava2.solo307.interview;

public class Main {
	public static void main(String[] args) {
		Interview myInterview = new Interview();
		myInterview.fillQuestionList();
		Menu.printMenu();
		Menu.chooseOperation(Menu.ReadInt());
	}
}
