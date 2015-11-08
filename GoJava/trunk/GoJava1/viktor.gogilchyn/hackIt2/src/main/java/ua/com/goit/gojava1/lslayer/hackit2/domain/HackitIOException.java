package ua.com.goit.gojava1.lslayer.hackit2.domain;

public class HackitIOException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -3422077847621274752L;

    public HackitIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public HackitIOException(String message) {
        super(message);
    }
}
