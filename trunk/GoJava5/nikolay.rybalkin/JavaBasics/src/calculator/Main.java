package calculator;

public class Main {

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
        int num1 = 0;
        int num2 = 0;
        String operand = words[1];

        try {
            num1 = Integer.parseInt(words[0]);
            num2 = Integer.parseInt(words[2]);
            System.out.println(num1);
            System.out.println(num2);
        } catch (NumberFormatException nfe) {
            System.out.println("Exception in: " +  nfe);
        }

        if ((operand.equals("/")) || (operand.equals("*")) || (operand.equals("-")) || (operand.equals("+"))){
            int result =  Calc.calc(num1, operand, num2);
            System.out.println("Result: " + result);
        }else{
            System.out.println("Unable to perform the operation, you have entered is not correct operand: " + operand);
        }


    }
}