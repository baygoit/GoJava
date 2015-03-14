/**
 * Created by roznalex on 13.03.2015.
 */
public class LonelyInteger {
    public static void main(String[] args) {
        LonelyInteger test = new LonelyInteger();
        int[] numbers = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4, 7, 7, 13};
        int singleton = test.searchSingleton(numbers);
        System.out.println(singleton);
    }


    int searchSingleton(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        String temp;
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            temp = Integer.toBinaryString(numbers[i]);
            sum += Integer.parseInt(temp);
        }
        char[] chars = Integer.toString(sum).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            builder.append(Character.getNumericValue(chars[i]) % 3);
        }
        temp = builder.toString();
        sum = Integer.parseInt(temp, 2);

        return sum;
    }
}
