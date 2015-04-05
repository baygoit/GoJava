package ua.goit.alg.xmlparser.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface Parser {
  public String parse(String string) throws IOException;
  public String parse(File file) throws IOException;
  public String parse(InputStream inputStream) throws IOException;
}
