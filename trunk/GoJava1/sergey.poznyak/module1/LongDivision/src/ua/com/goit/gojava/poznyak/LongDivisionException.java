package ua.com.goit.gojava.poznyak;

/**
 * Exception class.
 * 
 * @version 3.0 17 Mar 2015
 * @author Sergey Poznyak
 */
@SuppressWarnings("serial")
public class LongDivisionException extends Exception {

	public LongDivisionException() {}

	public LongDivisionException(String message) {
		super(message);
	}

}
