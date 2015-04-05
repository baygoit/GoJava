package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 14.03.2015.
 */
public class Anagramm {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        printAnagramm(expression);
    }

    public static void printAnagramm(String expression) {
        String[] array = expression.split(" ");
        for (int i = 0; i < array.length; i++) {
            array[i] = new StringBuilder(array[i]).reverse().toString();
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
