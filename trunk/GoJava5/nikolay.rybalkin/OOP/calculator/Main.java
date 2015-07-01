package calculator;

public class Main {

    private static int num1;
    private static int num2;
    private static String operand;
    private static int result = 0;
    private static String scaning;

    public static void main(String[] args) {
        System.out.println("Input line in format \"4 / 5\"");

        String[] words = Reader.read(scaning).split(" ");

        try {
            Integer.parseInt(words[0]);
            Integer.parseInt(words[2]);
        } catch (Exception e) {
            System.out.println("No number");
        }

        num1 = Integer.parseInt(words[0]);
        operand = words[1];
        num2 = Integer.parseInt(words[2]);

        result =  Calc.calc(num1, operand, num2);
        System.out.println("Result: " + result);
    }
}


//class Parser {
//
//    public static int parser(int num1, String operand, int num2){
//        int result = 0;
//        String[] words = Reader.read(scaning).split(" ");
//
//        try {
//            Integer.parseInt(words[0]);
//            Integer.parseInt(words[2]);
//        } catch (Exception e) {
//            System.out.println("No number");
//        }
//
//        num1 = Integer.parseInt(words[0]);
//        operand = words[1];
//        num2 = Integer.parseInt(words[2]);
//
//        return  result;
//    }
//}