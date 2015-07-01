package calculator;

import java.util.Scanner;

public class Main {

    private static int num1;
    private static int num2;
    private static String operand;

    public static void main(String[] args) {
        System.out.println("Input line in format \"4 / 5\"");

        Scanner scan = new Scanner(System.in);
        String scanString = scan.nextLine();
        String[] words = scanString.split(" ");


        try {
            Integer.parseInt(words[0]);
            Integer.parseInt(words[2]);
        } catch (Exception e) {
            System.out.println("No number");
        }

        num1 = Integer.parseInt(words[0]);
        operand = words[1];
        num2 = Integer.parseInt(words[2]);
        int result = 0;

        switch(operand){
            case "+": result = num1 + num2;
                break;
            case "-": result = num1 - num2;
                break;
            case "*": result = num1 * num2;
                break;
            case "/": result = num1 / num2;
                break;
        }

        System.out.println("Result:" + result);

    }
}
//
//class Calc {
//
//    public static int calc(int num1, String operand, int num2){
//
//        int result = 0;
//
//        switch(operand){
//            case "+": result = num1 + num2;
//                break;
//            case "-": result = num1 - num2;
//                break;
//            case "*": result = num1 * num2;
//                break;
//            case "/": result = num1 / num2;
//                break;
//        }
//        return result;
//    }
//}
//
//class Reader {
//
//    public static String read(String scanString){
//        Scanner scan = new Scanner(System.in);
//        scanString = scan.nextLine();
//        return scanString;
//    }
//}
//
//class Parser {
//
//    public static int parser(int num1, String operand, int num2){
//        int result = 0;
//
//        Reader parseString = new Reader();
//        String s = parseString.toString();
//        String[] words = s.split(" ");
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
//
////        System.out.println(num1 + " " + operand + " " + num2);
//        return  result;
//    }
//}