package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;

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
	
	public String descriptionString(){
		return "This method is called " + this.toString();
	}//TODO - delete
		
	public String resultString(){
		return "This is result of solving " + toString();
	}	
	
	public void describe(PrintStream outStream){
		outStream.println("This method is called " + this.toString());	
		//TODO - handle null
	}
}