package ua.com.goit.gojava7.distance;

public class App {

    public static void main(String[] args) {

        Console console = new Console();
        console.readUserInput();
        Distance.printDistance(console.parseUserInput(), 2);
        console.close();

    }

}
