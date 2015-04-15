package ua.goit.xmlparsertdd;

public class XMLSyntaxException extends Exception {

  public XMLSyntaxException(String msg) {
    super(msg);
  }

  public XMLSyntaxException() {
    super("XMLSyntaxException caught");
  }
}
