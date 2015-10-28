package ua.com.goit.gojava.solo307.intersim.dao;

public class InterviewSimulatorDaoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public InterviewSimulatorDaoException() {
		super();
	}

	public InterviewSimulatorDaoException(String arg0) {
		super(arg0);
	}

	public String getText() {
		return message;
	}
}
