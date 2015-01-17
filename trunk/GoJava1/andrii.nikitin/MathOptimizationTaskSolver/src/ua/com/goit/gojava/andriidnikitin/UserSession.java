package ua.com.goit.gojava.andriidnikitin;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSession {
	
	static ArrayList<String> listOfProblems;
	
	static ArrayList<String> guestBook;
	
	private PrintStream outStream;
	
	private SolubleProblem solubleProblemUnit;
	
	protected String userName;	
	
	private Scanner inputSource;
	
	static public final int COMMAND_UNKNOWN = -1;	
	
	static public final int COMMAND_EXIT = 0;
	
	static public final int COMMAND_BACK = -2;
	
	static public final int COMMAND_NEXT = -3;		

	static public final int FLAG_X = 1;		

	static public final int FLAG_XNB = 7;	
	
	
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
		UserSession actualSession =  
				new UserSession("default", System.in, System.out);
	}
	
	
	public UserSession (String login,  
			InputStream inStreamArg, PrintStream outStreamArg){
		userName = login;
		outStream = outStreamArg;
		inputSource = new Scanner (inStreamArg);
		addNewVisit();		
		startSession(login);
	}
	
	private void addNewVisit(){
		guestBook.add(userName + " has entered the system.");
	}
	
	private void startSession(String login){
		outStream.println("Welcome, " + login);
		launchMenu();
	}
	
	private void launchMenu(){
		printBlockSeparator();
		printProblemList();
		goFromMainMenu();
		//TODO - farawell();
	}			
		
	private void printProblemList(){
		outStream.println("Choose a problem You want to solve:\n");
		for (int i = 0; i < listOfProblems.size(); i++)
			outStream.println(i + 1 + " - " + listOfProblems.get(i) );
		outStream.println();
	}
	
	private void printBlockSeparator(){
		outStream.println("\n===========================================\n");
	}	
	
	private void printCommands(int flags){//TODO- refactor
		StringBuilder output = new StringBuilder();
		if (flags % 2 == 1) output.append("x - exit; ");
		flags = flags / 2;
		if (flags % 2 == 1) output.append("n - next; ");
		flags = flags / 2;
		if (flags % 2 == 1) output.append("b - back; ");
		flags = flags / 2;
		if (flags % 2 == 1) output.append("s - skip; ");
		outStream.println(output + "\n");
	}
	
	private int getCommand(){//TODO- refactor, too dirty
		String input =  getString();
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException exception){
		boolean exitCycle = false;
		while (!exitCycle){
			exitCycle = true;
			switch (input.charAt(0)){
				case 'x': return COMMAND_EXIT;
				case 'b': return COMMAND_BACK;
				case 'n': return COMMAND_NEXT;
				default : {
					outStream.println("Unknown command.");
					exitCycle = false;
					input =  getString();
				}
			}
		}
		}
		return COMMAND_UNKNOWN;
	}	
	
	private String getString(){
		return inputSource.nextLine();
	}
	
	private void chooseProblem(int numberOfProblem){//TODO - redo with cycle 
		switch (numberOfProblem){
			case 0: solubleProblemUnit = SolubleProblem.LINEAR_PROGRAM;
			break;
			case 1: solubleProblemUnit = SolubleProblem.TRANSPORTATION_PROBLEM;
			break;
			default: solubleProblemUnit = null;
			break;
		}
	}	
			
	private void goFromMainMenu(){//TODO- refactor
		printCommands(FLAG_X);
		int command = getCommand();
		switch (command){
			case COMMAND_EXIT: 
				return;
			case 1 : 
				chooseProblem(0);
				break;
			case 2 : 
				chooseProblem(1);
				break;
			default: command = getCommand();
			break;
		}
		goToProblem();
	}
	
	
	private void goToProblem(){//TODO- refactor
		solubleProblemUnit.describe(outStream);
		printCommands(FLAG_XNB);
		int command = getCommand();
		switch (command){
			case COMMAND_EXIT: 
				return;
			case COMMAND_BACK: 
				launchMenu();	
			case COMMAND_NEXT: 
				goToSolution();
			default: command = getCommand();
			break;
		}
	}
	
	private void goToSolution(){//TODO- refactor
		solubleProblemUnit.solveProblem(inputSource, outStream);
		printCommands(FLAG_XNB);
		int command = getCommand();
		switch (command){
			case COMMAND_EXIT: 
				return;
			case COMMAND_BACK: 
				goToProblem();	
			case COMMAND_NEXT: 
				launchMenu();
			default: command = getCommand();
			break;
		}
	}
}
