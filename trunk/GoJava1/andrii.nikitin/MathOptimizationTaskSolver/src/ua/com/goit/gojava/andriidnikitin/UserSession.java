package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;

public class UserSession {
	static ArrayList<String> listOfProblems;
	static ArrayList<String> guestBook;
	static {
		setProblemsList();
		setGuestBook();
	}
	
	public SolubleProblem solubleProblemUnit;
	protected String userName;
	
	public static UserSession newSession(String login){
		return new UserSession(login);
	}
	
	private UserSession (String login){
		userName = login;
		addNewVisit();
		startSession();
	}
	
	private void addNewVisit(){
		guestBook.add(userName+ " has entered the system.");
	}
	
	private void chooseProblem(int numberOfProblem){
		switch (numberOfProblem){
			case 0: solubleProblemUnit = SolubleProblem.LINEAR_PROGRAM;
			case 1: solubleProblemUnit = SolubleProblem.TRANSPORTATION_PROBLEM;
			default: solubleProblemUnit = null;
		}
	}

	public void startSession(){
		System.out.println("Your session is launched.");
		//printProblemList();
	}
	
	protected static void setProblemsList() {
		listOfProblems = new ArrayList<String>();
		listOfProblems.add(SolubleProblem.LINEAR_PROGRAM.toString());
		listOfProblems.add(SolubleProblem.TRANSPORTATION_PROBLEM.toString());
		//TODO: Extract list automatically.  
	}
	
	protected static void setGuestBook() {
		guestBook = new ArrayList<String>();
	}
	
	/*
	public static void printProblemList(){
		for (String row : listOfProblems)
	}*/
	public static void main(String[] args) throws Exception{
		UserSession actualSession = UserSession.newSession("default");
		actualSession.chooseProblem(0);
		System.out.println(actualSession.solubleProblemUnit.descriptionString());
	}
}
