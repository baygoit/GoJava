package goit.anagram;

import goit.common.Console;

public class Anagram {

    private static final String DELIMITER = " ";
    private static final String INVITE_MESSAGE = "Enter statement:";

    public static void main(String[] args) {
        Console console = new Console();
        do {
            String input = console.read(INVITE_MESSAGE);
            boolean firstIteration = false;
            for (String part : input.split(DELIMITER)) {
                if (firstIteration) {
                    console.write(DELIMITER);
                }
                console.write(new StringBuilder(part).reverse().toString());
                firstIteration = true;
            }
            console.write("\n");
        } while (console.hasNext());
        console.close();
    }
}
