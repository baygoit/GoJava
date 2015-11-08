package goit.anagram;

import goit.common.Console;

public class Bootstrap {
    private static final String INVITE_MESSAGE = "Enter statement:";

    public static void main(String[] args) {
        Console console = new Console();
        Anagram anagram = new Anagram();
        String input;
        do {
            input = console.read(INVITE_MESSAGE);
            console.writeLine(anagram.getAnargam(input));
        } while (console.hasNext());
        console.close();

    }
}
