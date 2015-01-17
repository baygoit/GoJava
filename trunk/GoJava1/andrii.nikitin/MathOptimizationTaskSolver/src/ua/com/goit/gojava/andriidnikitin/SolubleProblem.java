package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.Scanner;

public enum SolubleProblem {
	LINEAR_PROGRAM {
		public String toString(){
			return "Linear Program";
		}
	},
	TRANSPORTATION_PROBLEM {
		public String toString(){
			return "Transportation Problem";
		}
	};

	public void describe(PrintStream outStream){
		outStream.println("This problem is called " + this.toString());	
		//TODO - handle null
	}
	
	public void solveProblem(Scanner inStream, PrintStream outStream){
		outStream.println("Type magic number:");
		String result = inStream.nextLine();		
		try{
			outStream.println("Result is " + Integer.parseInt(result));
		} catch (NumberFormatException exception){
			outStream.println("Result is not a number");
		}
	}
}