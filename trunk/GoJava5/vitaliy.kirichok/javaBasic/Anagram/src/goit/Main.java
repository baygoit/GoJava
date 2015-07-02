package goit;

public class Main {

    public static final String DELIMITER = " ";

    public static void main(String[] args) {
        String exitCode;
        do {
            String input = Console.read("Enter statement:");
            boolean firstIteration = false;
            for (String part : input.split(DELIMITER)) {
                if (firstIteration) {
                    System.out.print(DELIMITER);
                }
                System.out.print(new StringBuilder(part).reverse().toString());
                firstIteration = true;
            }
            System.out.println();
            exitCode = Console.read("Repeat(" + Console.EXIT_CODE + " - yes, otherwise - exit)?");
        } while (exitCode.compareToIgnoreCase(Console.EXIT_CODE) == 0);
    }
}
