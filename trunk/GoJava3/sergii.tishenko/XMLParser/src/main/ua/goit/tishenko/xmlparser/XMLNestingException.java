package ua.goit.tishenko.xmlparser;

public class XMLNestingException extends Exception {
  private static final long serialVersionUID = 1L;

  public XMLNestingException () {

  }

  public XMLNestingException (String message) {
      super (message);
  }

  public XMLNestingException (Throwable cause) {
      super (cause);
  }

  public XMLNestingException (String message, Throwable cause) {
      super (message, cause);
  }
}