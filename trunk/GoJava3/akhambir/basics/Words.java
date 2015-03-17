import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 11.03.2015.
 */
public class Words {
    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = reader.readLine();
        StringBuilder builder = new StringBuilder();
        String space = " ";
        int index = 0;
        int index2;


        for (int i = 0; i < sentence.length(); i++) {
                index2 = i;
                if (space.equals(sentence.substring(index2, index2 + 1))) {
                    builder.insert(0, sentence.substring(index, index2) + " ");
                    index = i + 1;
                }else if (sentence.length() == i + 1) {
                    builder.insert(0, sentence.substring(index, index2 + 1) + " ");
                    index = i + 1;
                }
        }
        builder.reverse();
        String newWord = String.valueOf(builder.deleteCharAt(0));

        System.out.println(newWord);
    }
}
