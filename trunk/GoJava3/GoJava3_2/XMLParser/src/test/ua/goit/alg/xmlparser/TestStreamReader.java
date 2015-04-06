package test.ua.goit.alg.xmlparser;

import org.junit.Before;
import org.junit.Test;
import ua.goit.alg.xmlparser.input.StreamReader;

import java.io.*;
import java.nio.Buffer;

import static org.junit.Assert.assertEquals;

public class TestStreamReader {
  private File testXMLFile;

  @Before
  public void createTempResource() throws IOException {

    String path = System.getProperty("user.dir") + "\\resource\\textXMLFile.xml";
    testXMLFile = new File(path);
    testXMLFile.createNewFile();
    String xmlString = "<?xml version=\"1.0\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";

    PrintWriter out = null;
    try {
      out = new PrintWriter(testXMLFile);
      out.print(xmlString);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } finally {
      if(out != null) {
        out.close();
      }
    }

  }

  @Test
  public void testStreamReader_read_String() throws IOException {
    String xmlString = "<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";
    StreamReader stream = new StreamReader(xmlString);

    String actual = "";
    int symbol;
    do {
      symbol = stream.read();
      if (symbol == -1) {
        break;
      }
      actual += (char) symbol;
    } while (true);

    assertEquals(xmlString, actual);
  }

  @Test
  public void testStreamReader_read_emptyString() throws IOException {
    String xmlString = "";
    StreamReader stream = new StreamReader(xmlString);

    String actual = "";
    int symbol;
    do {
      symbol = stream.read();
      if (symbol == -1) {
        break;
      }
      actual += (char) symbol;
    } while (true);

    assertEquals(xmlString, actual);
  }

  @Test
  public void testStreamReader_read_File() throws IOException {
    String xmlString = "<?xml version=\"1.0\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";
    StreamReader stream = new StreamReader(testXMLFile);

    String actual = "";
    int symbol;
    do {
      symbol = stream.read();
      if (symbol == -1) {
        break;
      }
      actual += (char) symbol;
    } while (true);

    assertEquals(xmlString, actual);
  }

}
