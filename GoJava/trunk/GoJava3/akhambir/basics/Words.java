import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 11.03.2015.
 */
public class Words {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = reader.readLine();
        char space = ' ';
        int index = 0;
        int index2 = 0;

        for (int i = 0; i < sentence.length(); i++) {
            index2 = i;
            if (space == sentence.charAt(index2)) {
                index2--;
                while (index <= index2) {
                    System.out.print(sentence.charAt(index2));
                    index2--;
                }
                System.out.print(space);
                index = i + 1;
            } else if (sentence.length() == i + 1) {
                while (index <= index2) {
                    System.out.print(sentence.charAt(index2));
                    index2--;
                }
                index = i + 1;
            }
        }
    }
}
