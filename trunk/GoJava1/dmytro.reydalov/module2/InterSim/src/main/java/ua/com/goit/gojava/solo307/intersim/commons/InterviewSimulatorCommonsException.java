package ua.com.goit.gojava.solo307.intersim.commons;

public class InterviewSimulatorCommonsException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public InterviewSimulatorCommonsException() {
		super();
	}

	public InterviewSimulatorCommonsException(String arg0) {
		super(arg0);
	}

	public String getText() {
		return message;
	}
}
