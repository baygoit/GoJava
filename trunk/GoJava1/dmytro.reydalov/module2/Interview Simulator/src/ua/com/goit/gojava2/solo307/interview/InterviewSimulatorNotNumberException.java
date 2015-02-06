package ua.com.goit.gojava2.solo307.interview;

public class InterviewSimulatorNotNumberException extends Exception{
	
	private String text;
	
	public String getText() {
		return text;
	}

	public InterviewSimulatorNotNumberException(){
		text = "Exception caused wrong question ID in XMLParser";
	}
	
	
}
