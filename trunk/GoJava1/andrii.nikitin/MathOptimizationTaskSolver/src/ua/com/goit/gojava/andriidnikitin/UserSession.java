package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.ArrayList;

public class UserSession {
	
	static ArrayList<String> listOfProblems;
	
	static ArrayList<String> guestBook;
	
	private PrintStream outStream;
	
	public SolubleProblem solubleProblemUnit;//TODO - SET AS PRIVATE
	
	protected String userName;	
	
	void printBlockSeparator(){
		outStream.println("\n===========================================\n");
	}
	
	static {
		setProblemsList();
		setGuestBook();
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
	
	public static void main(String[] args) throws Exception{
		UserSession actualSession = UserSession.newSession("default", System.out);
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
	
	private void startSession(){
		System.out.println("Your session is launched.");
		printProblemList();
		
	}
	
	public void printProblemList(){
		outStream.println("Choose a problem You want to solve:");
		for (String row : listOfProblems)
			outStream.println('-' + row);
	}
	
	private void chooseProblem(int numberOfProblem){
		switch (numberOfProblem){
			case 0: solubleProblemUnit = SolubleProblem.LINEAR_PROGRAM;
			break;
			case 1: solubleProblemUnit = SolubleProblem.TRANSPORTATION_PROBLEM;
			break;
			default: solubleProblemUnit = null;
			break;
		}
	}		
}
