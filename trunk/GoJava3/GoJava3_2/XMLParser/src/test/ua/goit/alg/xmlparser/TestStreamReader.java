package test.ua.goit.alg.xmlparser;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.alg.xmlparser.input.StreamReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class TestStreamReader {

  @Test
  public void testStreamReader_read_String() throws IOException {

    final String xmlString = "<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>";
    StreamReader stream = new StreamReader(xmlString);

    String actual = "";
    int symbol;
    do {
      symbol = stream.read();
      if (symbol == -1) break;
      actual += (char) symbol;
    } while (true);

    assertEquals(xmlString, actual);
  }

  @Test
  public void testStreamReader_read_emptyString() throws IOException {
    final String xmlString = "";
    StreamReader stream = new StreamReader(xmlString);

    String actual = "";
    int symbol;
    do {
      symbol = stream.read();
      if (symbol == -1) break;
      actual += (char) symbol;
    } while (true);

    assertEquals(xmlString, actual);
  }

}
