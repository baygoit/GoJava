package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.ArrayList;

public class UserSession {
	
	static ArrayList<String> listOfProblems;
	
	static ArrayList<String> guestBook;
	
	private PrintStream outStream;
	
	public SolubleProblem solubleProblemUnit;
	
	protected String userName;
	
	
	static {
		setProblemsList();
		setGuestBook();
	}
	
	public static void main(String[] args) throws Exception{
		UserSession actualSession = UserSession.newSession("default", System.out);
		actualSession.chooseProblem(0);//TODO - DELETE
		System.out.println(actualSession.solubleProblemUnit.descriptionString());//TODO - DELETE
	}	
	
	public static UserSession newSession(String login, PrintStream outStreamArg){
		return new UserSession(login, outStreamArg);
	}
	
	private UserSession (String login, PrintStream outStreamArg){
		userName = login;
		outStream = outStreamArg;
		addNewVisit();		
		startSession();
	}
	
	private void addNewVisit(){
		guestBook.add(userName+ " has entered the system.");
	}
	
	public void startSession(){
		System.out.println("Your session is launched.");
		printProblemList(outStream);
	}
	
	private void chooseProblem(int numberOfProblem){
		switch (numberOfProblem){
			case 0: solubleProblemUnit = SolubleProblem.LINEAR_PROGRAM;
			case 1: solubleProblemUnit = SolubleProblem.TRANSPORTATION_PROBLEM;
			default: solubleProblemUnit = null;
		}
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
	
	public static void printProblemList(PrintStream outStream){
		for (String row : listOfProblems)
			outStream.println(row);
	}	
}
