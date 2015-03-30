package ua.goit.alg.sortBigFile;
import java.io.*;

public class BigFileWithIntCreation {
  private int intInFile = 12000000;// 48MB

  public void createBigFileWithInt(String bigFile) throws IOException {
    DataOutputStream dataToFile = new DataOutputStream(
            new FileOutputStream(new File(bigFile)));
    while (intInFile > 0) {
      int random = (int)(Math.random()*Integer.MAX_VALUE);
      dataToFile.writeInt(random);
      intInFile--;
    }
  }

  public static void main(String[] args) {
    BigFileWithIntCreation bigFileWithIntCreation = new BigFileWithIntCreation();

    try {
      bigFileWithIntCreation.createBigFileWithInt(Property.BIG_FILE_UNIX);
    } catch (IOException e) {
      throw new RuntimeException("aaaaaa file error");
    }
  }
}
