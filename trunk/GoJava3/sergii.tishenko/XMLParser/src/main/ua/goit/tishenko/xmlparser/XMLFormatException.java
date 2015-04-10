package ua.goit.tishenko.xmlparser;

public class XMLFormatException extends Exception {
  private static final long serialVersionUID = 1L;

  public XMLFormatException () {

  }

  public XMLFormatException (String message) {
      super (message);
  }

  public XMLFormatException (Throwable cause) {
      super (cause);
  }

  public XMLFormatException (String message, Throwable cause) {
      super (message, cause);
  }
}