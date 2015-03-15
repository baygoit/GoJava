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

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int indexOfMin1 = 0;
        int indexOfMin2 = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min2) {
                min2 = min1;
                indexOfMin2 = indexOfMin1;
                min1 = list.get(i);
                indexOfMin1 = i;
            }
        }

        int distance = Math.max(indexOfMin1, indexOfMin2) - Math.min(indexOfMin1, indexOfMin2);

        System.out.println(String.format("Two min numbers are %d and %d, distance between them is %d", min1, min2, distance));
    }
}
