import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by Aleksey Kurkov on 11.03.15.
 */

/*  Test cases
    1) Input: 23 45 34 12 45 4 38 56 2 49 100    Output: min1[5] = 4   min2[8] = 2   Distance = 3
    2) Input: 1 8 8 8 1                          Output: min1[0] = 1   min2[4] = 1   Distance = 4
    3) Input: 3 1 2 2                            Output: min1[1] = 1   min2[3] = 2   Distance = 1
*/


public class DistanceCalculator {
    private static int distance;
    private static int min1;
    private static int min2;
    private static int index1;
    private static int index2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string of numbers: ");

        String string = scanner.nextLine();
        String[] stringArray = string.split(" ");

        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        min1 = intArray[0];
        index1 = 0;
        min2 = intArray[1];
        index2 = 1;

        for (int i = 2; i < intArray.length; i++) {
            if (intArray[i] < max(min1, min2)) {
                if (min1 < min2) {
                    min2 = intArray[i];
                    index2 = i;
                } else {
                    min1 = intArray[i];
                    index1 = i;
                }
                distance = abs(index1 - index2);
            } else if (intArray[i] == max(min1, min2)) {
                min1 = min(min(min1, min2), intArray[i]);
                index1 = min(index1, index2);
                min2 = intArray[i];
                index2 = i;
                distance = min(distance, abs(index1 - index2));
            }
        }

        System.out.println("\nmin1[" + index1 + "] = " + min1);
        System.out.println("min2[" + index2 + "] = " + min2);
        System.out.println("Distance = " + distance);
    }
}