package goit;

public class Main {

    public static void main(String[] args) {
        String exitCode;
        do {
            String input = Console.read("Enter numbers:");
            LonelyNumber lonelyNumber = new LonelyNumber(Converter.convert(input));
            System.out.println("Appearance: " + lonelyNumber.getMinValue());
            System.out.println("Values: " + lonelyNumber.retrieve());
            exitCode = Console.read("Repeat? (" + Console.EXIT_CODE + " - yes, otherwise - exit)");
        } while (exitCode.compareToIgnoreCase(Console.EXIT_CODE) == 0);
    }
}
