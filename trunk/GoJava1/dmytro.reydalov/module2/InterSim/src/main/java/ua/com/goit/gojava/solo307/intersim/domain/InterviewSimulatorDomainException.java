package ua.com.goit.gojava.solo307.intersim.domain;

public class InterviewSimulatorDomainException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public InterviewSimulatorDomainException() {
		super();
	}

	public InterviewSimulatorDomainException(String arg0) {
		super(arg0);
	}

	public String getText() {
		return message;
	}
}
