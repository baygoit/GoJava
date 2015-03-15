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
        //We have an array of integers
        int[] array = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4};

        //Convert to binary presentation of integers and find the max length
        String[] binary = new String[array.length];
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            binary[i] = Integer.toBinaryString(array[i]);
            if (binary[i].length() > maxLength) {
                maxLength = binary[i].length();
            }
        }

        //Add zeros for the same length of every binary number
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i].length() < maxLength) {
                sb.append(binary[i]);
                while (sb.length() != maxLength) {
                    sb.insert(0, "0");
                }
                binary[i] = sb.toString();
                sb.delete(0, sb.length());
            }
        }

        //Summation of significant digits and division on the count of repetition
        int sum = 0;
        for (int i = 0; i < binary[0].length(); i++) {
            for (String s : binary) {
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            if (sum % COUNT_OF_REPETITION == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sum = 0;
        }

        //Convert the lonely number from binary to decimal and output to console
        System.out.println("The lonely number is " + Integer.parseInt(sb.toString(), 2));
    }
}
