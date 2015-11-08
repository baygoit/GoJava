package ua.com.goit.gojava.alejnikovi.medsystem;

public class MedicalSystemException extends Exception{

	private static final long serialVersionUID = -7637948600485107535L;

	public MedicalSystemException(String message) {
		super(message);
	}
	
	public MedicalSystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
