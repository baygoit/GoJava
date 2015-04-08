package test.ua.goit.alg.xmlparser;

import org.junit.Before;
import org.junit.Test;
import ua.goit.alg.xmlparser.input.StreamReader;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class StreamReaderTest {
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
      if (out != null) {
        out.close();
      }
    }
  }

  @Test
  public void testStreamReader_read_String() throws IOException {
    String xmlString = "<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";
    StreamReader stream = new StreamReader(xmlString);
    String actualXML = readString_actualXML(stream);
    assertEquals(xmlString, actualXML);
  }

  @Test
  public void readFromInputStreamReader() throws IOException {
    String xmlString = "<?xml version=\"1.0\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";
    InputStream reader = new FileInputStream(testXMLFile);
    StreamReader stream = new StreamReader(reader);
    String actualXML = readString_actualXML(stream);
    assertEquals(xmlString, actualXML);
  }

  @Test
  public void testStreamReader_read_emptyString() throws IOException {
    String xmlString = "";
    StreamReader stream = new StreamReader(xmlString);
    String actualXML = readString_actualXML(stream);
    assertEquals(xmlString, actualXML);
  }

  @Test
  public void testStreamReader_read_File() throws IOException {
    String xmlString = "<?xml version=\"1.0\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";
    StreamReader stream = new StreamReader(testXMLFile);
    String actualXML = readString_actualXML(stream);
    assertEquals(xmlString, actualXML);
  }

  private String readString_actualXML(StreamReader stream) throws IOException {
    StringBuilder actualXML = new StringBuilder();
    int symbol;
    do {
      symbol = stream.read();
      if (symbol == -1) {
        break;
      }
      actualXML.append((char) symbol);
    } while (true);
    return actualXML.toString();
  }
}
