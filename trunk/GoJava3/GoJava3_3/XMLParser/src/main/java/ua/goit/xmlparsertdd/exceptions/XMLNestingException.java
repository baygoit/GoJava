package ua.goit.xmlparsertdd.exceptions;

public class XMLNestingException extends Exception{

  public XMLNestingException(String msg) {
    super(msg);
  }
  public XMLNestingException( ) {
    super("XML error");
  }

}
