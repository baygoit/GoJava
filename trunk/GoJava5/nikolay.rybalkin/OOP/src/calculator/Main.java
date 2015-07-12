package calculator;

public class Main {

    private static int result = 0;

    public static void main(String[] args) {

        ScanConsole scanConsole = new ScanConsole();

        System.out.println("Input line in format \"4 / 5\"");

        String[] words = scanConsole.consoleScan().split(" ");

        int num1 = Integer.parseInt(words[0]);
        String operand = words[1];
        int num2 = Integer.parseInt(words[2]);


        num1 = Integer.parseInt(words[0]);
        operand = words[1];
        num2 = Integer.parseInt(words[2]);

        result =  Calc.calc(num1, operand, num2);
        System.out.println("Result: " + result);
    }
}