package utils;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 02.09.15
 * Time: 7:57
 */
public class RWFileService {
    public static StringBuilder getTextFromFile(String path, char delimiter){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("Incorrect encoding format for file: " + path, e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't find file: " + path, e);
        }
        StringBuilder builder = new StringBuilder();
        String str;
        try {
            while((str = br.readLine()) != null){
                builder.append(str);
                builder.append(delimiter);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't read file: " + path, e);
        }
        return builder;
    }
}
