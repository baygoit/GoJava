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
        for (Integer integer : list) {
            if (integer < min1) {
                min1 = integer;
            }
        }
        int indexOfMin1 = list.indexOf(min1);

        int min2 = Integer.MAX_VALUE;
        for (Integer integer : list) {
            if (integer == min1) {
                continue;
            }
            if (integer < min2) {
                min2 = integer;
            }
        }
        int indexOfMin2 = list.indexOf(min2);

        int distance;
        if (indexOfMin1 > indexOfMin2) {
            distance = indexOfMin1 - indexOfMin2;
        } else {
            distance = indexOfMin2 - indexOfMin1;
        }
        System.out.println("Наименьшие числа " + min1 + " и " + min2 + ". Расстояние между ними - " + distance);
    }
}
