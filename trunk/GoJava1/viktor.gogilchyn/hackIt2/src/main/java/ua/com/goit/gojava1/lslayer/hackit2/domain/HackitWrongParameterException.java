package ua.com.goit.gojava1.lslayer.hackit2.domain;

public class HackitWrongParameterException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -5379227514593310841L;

    public HackitWrongParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public HackitWrongParameterException(String message) {
        super(message);
    }

}
