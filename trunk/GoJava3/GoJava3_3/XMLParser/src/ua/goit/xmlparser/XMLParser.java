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
    new Handler() {
      @Override
      public void handle(Tag tag) {

      }
    };
  }

  public void onTextValue() {
    new Handler() {
      @Override
      public void handle(Tag tag) {

      }
    };
  }

  public void onStart() {
    new Handler() {
      @Override
      public void handle(Tag tag) {

      }
    };
  }

  public void onEnd() {
    new Handler() {
      @Override
      public void handle(Tag tag) {

      }
    };
  }

  public void onError() {
    new Handler() {
      @Override
      public void handle(Tag tag) {

      }
    };
  }

}
