
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ольга on 11.03.2015.
 */


/*
 * Твоя задача создать консольное приложение, которое принимало бы на вход ряд чисел
 * и выводило расстояние между двумя наименьшими. Например, дано ряд чисел: "23 45 34 12 45 4 38 56 2 49 100".
 * Наименьшие числа в нем 2 и 4. Расстояние между ними - 3.
 */

/*
Test cases
Input: 1 2 2 1 2 1
Output: 2

Input: 1 2 1 2 2 1
Output: 3
 */

public class Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        String numbers = reader.readLine();

        String[] array = numbers.split(" ");
        int n;
        for (String s : array) {
            n = Integer.parseInt(s);
            list.add(n);
        }

        int min1 = list.get(0);
        int min2 = list.get(0);
        int indexOfMin1 = 0;
        int indexOfMin2 = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= min1) {
                min2 = min1;
                indexOfMin2 = indexOfMin1;
                min1 = list.get(i);
                indexOfMin1 = i;
            }
        }

        int distance = Math.abs(indexOfMin1 - indexOfMin2);

        System.out.println(String.format("Two min numbers are %d and %d, distance between them is %d", min1, min2, distance));
    }
}



