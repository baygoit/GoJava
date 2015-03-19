/**
 Created by kossovec on 16.03.2015.

 You have an array of integers where each number appears 3 times except one.
 Like [2, 3, 2, 4, 3, 7, 2, 3, 4, 4]. Please find this ‘lonely’ integer number in array.
 Test arr NUMBERS = {9, 2, 3, 2, 3, 2, 3, 4, 4, 4, 1, 1, 1, 5, 5, 5, 6, 6, 6, 11, 11, 11};
 */
package konstantin.malov;

public class Exe002001 {
    private static final int[] NUMBERS = {9, 2, 3, 2, 3, 2, 3, 4, 4, 4, 1, 1, 1, 5, 5, 5, 6, 6, 6, 11, 11, 11};
    private static  int[] countArray = new int[32];
    public static void main(String[] args) {
        System.out.println(lonelyNumber(NUMBERS));
    }

    public static int lonelyNumber(int[] numberArray) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numberArray.length; i++) {
            int counter = 0;
            while (numberArray[i] > 0) {
                if((numberArray[i] & 1) == 1) {
                    countArray[countArray.length - 1 - counter] += 1;
                }
                numberArray[i] >>= 1;
                counter++;
            }
        }
        for (int i = 0; i < countArray.length; i++) {
            builder.append(countArray[i] % 3);
        }
        return Integer.parseInt(builder.toString(), 2);
    }

}
