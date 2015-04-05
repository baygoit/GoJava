package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 14.03.2015.
 */
public class LonelyInteger {

    public static int findLonelyInteger() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayStr = new String[0];
        try {
            arrayStr = reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] array = new int[arrayStr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        return findLonelyInteger(array);
    }

    public static int findLonelyInteger(int[] array) {
        int[] resultArray = new int[32];
        String result = "";
        for (int i : array) {
            int mask = 1;
            for (int j = 0; j < 32; j++) {
                if ((i & mask) == mask) {
                    resultArray[j]++;
                }
                mask <<= 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (resultArray[i] % 3 == 0) {
                result += 0;
            } else {
                result += 1;
            }
        }
        result = new StringBuilder(result).reverse().toString();
        return Integer.parseInt(result, 2);
    }
}
