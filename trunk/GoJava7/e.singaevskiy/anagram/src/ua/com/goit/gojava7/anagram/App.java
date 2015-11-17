package ua.com.goit.gojava7.anagram;

public class App {

    public static void main(String[] args) {

        Console console = new Console();
        System.out.println(Anagram.reverse(console.getUserInput()));
        console.close();

    }

}
