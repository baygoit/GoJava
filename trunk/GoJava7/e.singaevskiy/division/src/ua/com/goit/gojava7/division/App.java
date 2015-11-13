package ua.com.goit.gojava7.division;

public class App {

    public static void main(String[] args) {

        Console console = new Console();
        console.readUserInput();
        int[] numbers = console.parseUserInput();
        Division.printDivision(numbers[0], numbers[1]);
        console.close();

    }

}
