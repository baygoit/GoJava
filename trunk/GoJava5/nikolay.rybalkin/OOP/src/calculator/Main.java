package calculator;

public class Main {

    private static int num1 = 0;
    private static int num2 = 0;
    private static String operand = null;
    private static int result = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Input line in format \"4 / 5\"");

            ScanConsole scanConsole = new ScanConsole();
            String[] words = scanConsole.consoleScan().split(" ");

            if (words.length < 3) {
                System.out.println("No valid format");
            } else {
                resultCalk(words);
            }
        }
    }

    private static void resultCalk(String[] words) {
        num1 = Integer.parseInt(words[0]);
        operand = words[1];
        num2 = Integer.parseInt(words[2]);
        result =  Calc.calc(num1, operand, num2);
        System.out.println("Result: " + result);
    }
}