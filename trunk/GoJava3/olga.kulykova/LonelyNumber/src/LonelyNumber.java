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

Input: 2,5,6,6,2,3,5,6,5,2
Output: 3

Input: 5,5,5,3,4,4,4
Output: 3
 */

public class LonelyNumber {
    final static int COUNT_OF_REPETITION = 3;

    public static void main(String[] args) {
        int[] array = {5,5,5,3,4,4,4};
        int sum = 0;
        int result = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int mask = 1 << i;
            for (Integer integer : array) {
                int bit = integer & mask;
                if (bit > 0) {
                    sum = sum + bit;
                }
            }
            if(sum % COUNT_OF_REPETITION > 0) {
                result = result | mask;
            }
            sum = 0;
        }

        System.out.println("The lonely number is " + result);
    }
}
