package ua.goit.xmlparsertdd;

public class XMLNestingException extends Exception{

  public XMLNestingException(String msg) {
    super(msg);
  }
  XMLNestingException( ) {
    super("XML error");
  }

}
