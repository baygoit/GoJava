package goit.anagram;

public class Anagram {

    private static final String DELIMITER = " ";

    public String getAnargam(String inputString) {
        if (inputString == null) {
            return new String();
        }
        String result = "";
        for (String part : inputString.split(DELIMITER)) {
            result = result.concat(new StringBuilder(part).reverse().toString()).concat(DELIMITER);
        }
        return result.trim();
    }
}
