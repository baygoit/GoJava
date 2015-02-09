package ua.com.goit.gojava.poznyak;

/**
 * Exception class.
 * 
 * @version 2.0 25 Jan 2015
 * @author Sergey Poznyak
 */
@SuppressWarnings("serial")
public class LongDivisionException extends Exception {

	public LongDivisionException() {}

	public LongDivisionException(String message) {
		super(message);
	}

}
