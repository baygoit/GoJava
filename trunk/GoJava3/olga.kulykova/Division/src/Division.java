import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ольга on 12.03.2015.
 */

/*Твоя задача реализовать программу, которая визуализирует деление в столбик в консоли в текстовом режиме.
        Например, на вход передается строка "12/42", программа напечатает:
 */


public class Division {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task = reader.readLine();
        String[] array = task.split("/");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);

        String result = doResultInString(a, b);
        drawSolution(a, b, result);
    }

    public static String doResultInString(int a, int b) {
        List<Integer> list = new LinkedList<Integer>(); //for checking period
        StringBuilder result = new StringBuilder();

        while (true) {
            //Divide more on less
            if (a >= b) {
                result.append(a / b);
                a %= b;
                //If no rest
                if (a == 0) {
                    return result.toString();
                }
            } else {
                //Add coma
                if (result.toString().equals("")) {
                    result.append("0,");
                }
                if (! result.toString().contains(",")) {
                    result.append(",");
                }
                //Divide after coma and find period
                while (true) {
                    a *= 10;
                    while (a < b) {
                        list.add(a);
                        a *= 10;
                        result.append(0);
                    }
                    if (list.contains(a)) {
                        int indexList = list.indexOf(a);
                        int indexSb = result.indexOf(",");
                        result.insert(indexList + indexSb + 1, "(");
                        result.append(")");
                        return result.toString();
                    } else {
                        list.add(a);
                        break;
                    }
                }
            }
        }
    }

    public static void drawSolution(int a, int b, String result) {
        System.out.println(a + "  |" + b);

        while (a < b) {
            a *= 10;
        }
        int c = a / b;
        int d = c * b;

        System.out.println(-d + " |" + result);

        String separator = "-";
        String space = " ";
        int countA = 0;        //count spaces for A
        int countD = 0;        //count spaces for D

        //Draw the line
        String sd = Integer.toString(d);
        for (int i = 0; i <= sd.length(); i++) {
            System.out.print(separator);
        }
        System.out.println();

        //Count of digits in result
        int countDigits = 0;
        char[] chars = result.toCharArray();
        for (Character aChar : chars) {
            if (Character.isDigit(aChar)) {
                countDigits++;
            }
        }

        //Draw solution
        while (countDigits > 1) {
            countA++;
            a -= d;
            if (a == 0) {
                for (int i = 0; i < countA; i++) {
                    System.out.print(space);
                }
                System.out.println(a);
                break;
            }
            while (a < b) {
                a *= 10;
            }
            for (int i = 0; i < countA; i++) {
                System.out.print(space);
            }
            System.out.println(a);
            c = a / b;
            d = c * b;
            for (int i = 0; i < countD; i++) {
                System.out.print(space);
            }
            System.out.println(-d);
            for (int i = 0; i < countD; i++) {
                System.out.print(space);
            }
            sd = Integer.toString(d);
            for (int i = 0; i <= sd.length(); i++) {
                System.out.print(separator);
            }
            System.out.println();
            countD++;
            countDigits--;
        }
    }
}