package ua.goit.alg.xmlparser.input;

import java.io.*;

public class StreamReader {
  private Reader reader = null;

  public StreamReader(String inputData) {
    reader = new StringReader(inputData);
  }

  public StreamReader(File inputData) throws FileNotFoundException {
    reader = new BufferedReader(new FileReader(inputData));
  }

  public StreamReader(InputStream inputStream) {
    reader = new BufferedReader(new InputStreamReader(inputStream));
  }

  public int read() throws IOException {
    int i = reader.read();
    if (i == -1) {
      close();
    }
    return i;
  }

  public void close() {
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}