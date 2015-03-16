/**
 * Created by Ольга on 15.03.2015.
 */

/*
You have an array of integers where each number appears 3 times except one.
Like [2, 3, 2, 4, 3, 7, 2, 3, 4, 4]. Please find this ‘lonely’ integer number in array.
*/

/*
Test case
We have array of integers: 2, 3, 2, 4, 3, 7, 2, 3, 4, 4
Output: The lonely number is 7
 */

public class LonelyNumber {
    final static int COUNT_OF_REPETITION = 3;

    public static void main(String[] args) {
        int[] array = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4};
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Integer.SIZE; i++) {
            for (Integer integer : array) {
                int mask = 1 << i;
                int bit = integer | mask;
                if (bit > 0) {
                    sum = sum | bit;
                }
            }
            if (sum % COUNT_OF_REPETITION == 0) {
                sb.insert(0, 0);
            } else {
                sb.insert(0, 1);
            }
            sum = 0;
        }

        //Convert the lonely number from binary to decimal and output to console
        System.out.println("The lonely number is " + Integer.parseInt(sb.toString(), 2));
    }
}
