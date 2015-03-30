package ua.goit.xmlparser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XMLParser {

  public void Parsre(String strArg) {

    Parsre(new ByteArrayInputStream(strArg.getBytes()));
  };

  public void Parsre(File strArg) throws FileNotFoundException {

    Parsre(new FileInputStream(strArg));
  };

  public void Parsre(InputStream iStreamReader) {
     XMLElementsReader xmlStreamReader = new XMLElementsReader(iStreamReader) ;
  };

}
