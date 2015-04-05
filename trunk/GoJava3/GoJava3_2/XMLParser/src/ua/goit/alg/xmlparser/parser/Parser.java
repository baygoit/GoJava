package ua.goit.alg.xmlparser.parser;

import java.io.File;
import java.io.IOException;

public interface Parser {
  public String parse(String string) throws IOException;
  public String parse(File file) throws IOException;
}
