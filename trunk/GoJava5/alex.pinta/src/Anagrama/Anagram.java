package Anagrama;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 18.07.15
 * Time: 17:21
 * @version: 1.0
 */
public class Anagram {
    public final String REGEX_STRING = " ";
    private String analyzedString;
    public Anagram(String prompt) {
        analyzedString = prompt;
    }

    public String replace(){
        String tmp = "";
        for (String elem : analyzedString.split(REGEX_STRING)){
            StringBuilder stringBuilder = new StringBuilder(elem);
            tmp += (tmp.equals("") ? "": " ") + stringBuilder.reverse().toString();
        }
    return tmp;
    }
}
