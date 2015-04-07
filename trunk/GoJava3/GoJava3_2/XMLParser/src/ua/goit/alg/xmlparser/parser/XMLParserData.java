package ua.goit.alg.xmlparser.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import ua.goit.alg.xmlparser.input.StreamReader;
import ua.goit.alg.xmlparser.statemashines.StateMashineTag;

public class XMLParserData implements Parser {
  
  private StreamReader reader;
  private StateMashineTag tag;
  private XMLParser parser;
  
  public XMLParserData(XMLParser parser){
    this.parser = parser;
  }
  
  public String parse(String string) throws IOException {
    reader = new StreamReader(string);
    return parseReader(reader);
  }

  public String parse(File file) throws IOException {
    reader = new StreamReader(file);
    return parseReader(reader);
  }

  @Override
  public String parse(InputStream inputStream) throws IOException {
    reader = new StreamReader(inputStream);
    return parseReader(reader);
  }
  
  public void close(){
    reader.close();
  }

  private String parseReader(StreamReader reader) throws IOException {
    tag = new StateMashineTag(parser);
    int symbol;
    do {
      symbol = reader.read();
      tag.next((char) symbol);
    } while (symbol != -1);
    return "";
  }
  

}
