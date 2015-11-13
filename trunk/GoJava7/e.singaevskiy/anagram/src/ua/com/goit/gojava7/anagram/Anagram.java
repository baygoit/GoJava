package ua.com.goit.gojava7.anagram;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {

    private static final String PATTERN = "[A-zА-ЯЁё]+";

    private Anagram() {
    }

    public static String reverse(String text) {

        StringBuilder rezult = new StringBuilder(text);
        Matcher matcher = Pattern.compile(PATTERN).matcher(text);

        while (matcher.find()) {
            rezult.replace(matcher.start(), matcher.end(), new StringBuilder(matcher.group()).reverse().toString());
            System.out.println(matcher.group());
        }

        return rezult.toString();
    }

}
