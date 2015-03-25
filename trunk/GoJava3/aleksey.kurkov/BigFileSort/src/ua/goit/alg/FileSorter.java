package ua.goit.alg;

import java.io.*;
import java.nio.CharBuffer;

/**
 * Created by Aleksey Kurkov on 3/25/15.
 */

public class FileSorter {

  static FileReader fileReader;
  static final int BUF_SIZE = 10;
  static FileWriter fileWriter;

  public static void main(String[] args) throws IOException {

    /*fileReader = new FileReader("BigFile.txt");
    fileWriter = new FileWriter("temp.txt");

    try {
      while (fileReader.ready()){
        int length = fileReader.read(CharBuffer.allocate(10));
        for (int i = 0; i < length; i++) {
          fileWriter.write(String.valueOf(length) + " ");
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    finally {
      fileReader.close();
      fileWriter.close();
    }
  }*/

    InputStream is = new InputStream() {
      @Override
      public int read() throws IOException {
        return 0;
      }
    };
    OutputStream os = new OutputStream() {
      @Override
      public void write(int b) throws IOException {

      }
    };

    byte buffer[] = new byte[1024];
    int read;
    while ((read = is.read(buffer)) != -1) {
      os.write(buffer, 0, read);
    }
  }
}
