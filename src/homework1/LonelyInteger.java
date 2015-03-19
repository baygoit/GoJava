package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 14.03.2015.
 */
public class LonelyInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayStr = reader.readLine().split(" ");
        int[] array = new int[arrayStr.length];
        for (int i=0;i<array.length;i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        findLonelyInteger(array);
    }

    public static int findLonelyInteger(int[] array) {
        int[] resultArray = new int[32];
        String result = "";
        for (int i:array) {
            int mask = 1;
            for (int j=0;j<32;j++) {
                if ((i & mask) == mask) {
                    resultArray[j]++;
                }
                mask <<= 1;
            }
        }
        for (int i=0;i<32;i++) {
            if (resultArray[i]%3==0) {
                result += 0;
            } else {
                result += 1;
            }
        }
        result = new StringBuffer(result).reverse().toString();
        return Integer.parseInt(result, 2);
    }
}
