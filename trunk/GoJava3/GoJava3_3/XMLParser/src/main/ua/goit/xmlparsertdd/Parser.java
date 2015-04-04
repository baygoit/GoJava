package ua.goit.xmlparsertdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public interface Parser {
  void parse(File file) throws FileNotFoundException;
  void parse(String string);
  void parse(InputStream inputStream);
}
