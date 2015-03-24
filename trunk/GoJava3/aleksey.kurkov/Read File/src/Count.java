import java.io.*;
import java.net.URL;

/**
 * Created by Алексей on 24.03.2015.
 */
public class Count {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = null;
        URL path = ClassLoader.getSystemResource("text.txt");
        try {
            fileReader = new FileReader(String.valueOf(path));
            char[] buffer = new char[1024];
            int count = 0;
            while (fileReader.ready()){
                int length = fileReader.read(buffer);
                for (int i = 0; i < length; i++) {
                    if (buffer[i] == '\n'){
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            fileReader.close();
        }

    }

    public static FileReader countEnter() throws Exception {
        FileReader fileReader;
        URL path = ClassLoader.getSystemResource("text.txt");
        fileReader = new FileReader(String.valueOf(path));
        char[] buffer = new char[1024];
        int count = 0;
        while (fileReader.ready()){
            int length = fileReader.read(buffer);
            for (int i = 0; i < length; i++) {
                if (buffer[i] == '\n'){
                    count++;
                }
            }
        }
        System.out.println(count);
        return fileReader;
    }
}
