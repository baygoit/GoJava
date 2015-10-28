package goit.common;

public class ParseException extends Exception {

    public ParseException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
