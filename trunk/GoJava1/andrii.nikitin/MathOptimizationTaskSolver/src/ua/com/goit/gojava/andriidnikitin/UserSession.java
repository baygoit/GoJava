package ua.com.goit.gojava.andriidnikitin;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSession {
	
	static ArrayList<String> listOfProblems;
	
	static ArrayList<String> guestBook;
	
	private PrintStream outStream;
	
	public SolubleProblem solubleProblemUnit;//TODO - SET AS PRIVATE
	
	protected String userName;	
	
	private Scanner inputSource;
	
	static public final int COMMAND_UNKNOWN = -1;	
	
	static public final int COMMAND_EXIT = 0;
	
	static public final int COMMAND_BACK = -2;
	
	static public final int COMMAND_NEXT = -3;		

	static public final int FLAG_X = 0;	
	
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
				UserSession.newSession("default", System.out, System.in);
	}
	
	public static UserSession newSession(String login, PrintStream outStreamArg,
			InputStream inStreamArg){
		return new UserSession(login, outStreamArg, inStreamArg);
	}
	
	private UserSession (String login, PrintStream outStreamArg, 
			InputStream inStreamArg){
		userName = login;
		outStream = outStreamArg;
		inputSource = new Scanner (inStreamArg);
		addNewVisit();		
		startSession();
	}
	
	private void addNewVisit(){
		guestBook.add(userName+ " has entered the system.");
	}
	
	private void startSession(){
		outStream.println("Your session is launched.");
		launchMenu();
	}
	
	private void printProblemList(){
		outStream.println("Choose a problem You want to solve:\n");
		for (int i = 0; i < listOfProblems.size(); i++)
			outStream.println(i + " - " + listOfProblems.get(i) );
		outStream.println();
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
	
	private void printBlockSeparator(){
		outStream.println("\n===========================================\n");
	}	
	
	private void printCommands(int flags){
		StringBuilder output = new StringBuilder();
		output.append("x - exit; ");
		if (flags / 2 == 0) output.append("n - next; ");
		if (flags / 2 == 1) output.append("b - back; ");
		if (flags / 4 == 1) output.append("v - vendetta; ");//TODO - delete
		outStream.println(output);
	}
	
	private int getCommand(){
		char inputSymbol =  getChar();
		try {
			return Integer.parseInt(Character.toString(inputSymbol));
		} catch (Exception e){
			
		}
		boolean exitCycle = false;
		while (!exitCycle){
			exitCycle = true;
			switch (inputSymbol){
				case 'x': return COMMAND_EXIT;
				case 'b': return COMMAND_BACK;
				case 'n': return COMMAND_NEXT;
				default : {
					outStream.println("Unknown command.");
					exitCycle = false;
					inputSymbol =  getChar();
				}
			}
		}
		return COMMAND_UNKNOWN;
	}	
	
	private void launchMenu(){
		printBlockSeparator();
		printProblemList();
		goNext();
		//TODO - farawell();
	}
	
	private void goNext(){
		goFromMainMenu();
	}
	
	private char getChar(){
			return (char) inputSource.nextInt();
	}
	
	private void goFromMainMenu(){
		printCommands(FLAG_X);
		int command = getCommand();
		switch (command){
			case COMMAND_EXIT: return;
			case COMMAND_UNKNOWN :{
				//throw new IllegalArgumentException(); TODO - make correct exception
				return;//TODO - delete
			}
			//break; TODO - perform all this 3 todo's as one
			case 1 : chooseProblem(1);
				break;
			case 2 : chooseProblem(2);
				break;
			default: return;
		}
		goToProblem();
	}
	private void goToProblem(){
		solubleProblemUnit.describe(outStream);
	}
}
