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
        String[] words = sentence.split(" ");
        String[] newWords = new String[words.length];


        StringBuilder newWord = new StringBuilder(words[0]);
        StringBuilder newWord1 = new StringBuilder(words[1]);
        StringBuilder newWord2 = new StringBuilder(words[2]);


        newWords[0] = String.valueOf(newWord.reverse());
        newWords[1] = String.valueOf(newWord1.reverse());
        newWords[2] = String.valueOf(newWord2.reverse());


        System.out.println(newWords[0] + " " + newWords[1] + " " + newWords[2]);

    }
}
