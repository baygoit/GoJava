package ua.goit.alg.xmlparser.input;

import java.io.*;

public class StreamReader {
  private Reader inputStreamFile = null;

  public StreamReader(String inputData) throws FileNotFoundException {
    inputStreamFile = new StringReader(inputData);
  }

  public StreamReader(File inputData) throws FileNotFoundException {
    inputStreamFile = new BufferedReader(new FileReader(inputData));
  }

  public StreamReader(InputStream inputStream) {
    inputStreamFile = new BufferedReader(new InputStreamReader(inputStream));
  }

  public int read() throws IOException {
    int i = inputStreamFile.read();
    if (i == -1) {
      close();
    }
    return i;
  }

  public void close() throws IOException {
    inputStreamFile.close();
  }
}