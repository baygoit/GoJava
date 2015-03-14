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

        for(int i = 0; i < words.length; i++){
            StringBuilder newWord = new StringBuilder(words[i]);
            newWords[i] = String.valueOf(newWord.reverse());
        }

        for (String text : newWords)
        System.out.println(text);

    }
}
