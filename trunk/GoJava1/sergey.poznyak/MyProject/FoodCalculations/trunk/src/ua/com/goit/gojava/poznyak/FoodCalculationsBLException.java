package ua.com.goit.gojava.poznyak;

/**
 * This is the Business Logic exception.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
@SuppressWarnings("serial")
public class FoodCalculationsBLException extends Exception {

	public FoodCalculationsBLException() {}

	public FoodCalculationsBLException(String message) {
		super(message);
	}

	public FoodCalculationsBLException(Throwable cause) {
		super(cause);
	}
	
	public FoodCalculationsBLException(String message, Throwable cause) {
		super(message, cause);
	}

}
