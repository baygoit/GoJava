import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        double d = (double) a / b;
        String result = String.format("%.6f", d);
        if (d < 1 && d > -1) {
            String sub = result.substring(2);
            return "0.(" + sub + ")";
        } else {
            return result.substring(0, result.length());
        }

    }

    public static void drawSolution(int a, int b, String result) {
        System.out.println(a + " |" + b);

        while (a < b) {
            a *= 10;
        }
        int c = a / b;
        int d = c * b;

        System.out.println(-d + "|" + result);

        String separator = "-";
        String space = " ";
        int countA = 0;
        int countD = 0;

        String sd = Integer.toString(d);
        for (int i = 0; i <= sd.length(); i++) {
            System.out.print(separator);
        }
        System.out.println();


        while (countA < 5) {
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
        }
    }
}