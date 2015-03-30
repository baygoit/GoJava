package ua.goit.xmlparser;

import java.io.*;

public class XMLParser {

  public void parse(String strArg) {
    parse(new ByteArrayInputStream(strArg.getBytes()));
  }

  public void parse(File strArg) throws FileNotFoundException {
    parse(new FileInputStream(strArg));
  }

  public void parse(InputStream iStreamReader) {
    XMLElementsReader xmlStreamReader = new XMLElementsReader(iStreamReader);
  }

  public void onOpenTag() {

  }

  public void onTextValue() {

  }

  public void onStart() {

  }

  public void onEnd() {

  }

  public void onError() {

  }

}
