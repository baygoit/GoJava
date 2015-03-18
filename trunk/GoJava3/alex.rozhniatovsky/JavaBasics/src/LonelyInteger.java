/**
 * Created by roznalex on 13.03.2015.
 */
public class LonelyInteger {
    public static void main(String[] args) {
        LonelyInteger test = new LonelyInteger();
        int[] numbers = {20, 2, 3, 2, 3, 2, 3, 4, 4, 4, 1, 1, 1, 5, 5, 5, 6, 6, 6, 7, 7, 7};
        int singleton = test.searchSingleton(numbers);
        System.out.println(singleton);
    }

    int searchSingleton(int[] numbers) {
        int[] buffer = new int[32];
        int bufferLength = buffer.length;
        int singleton = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = buffer.length - 1;
            while (numbers[i] > 0) {
                //use the mask
                if ((numbers[i] & 1) == 1) {
                    buffer[count] += 1;
                }
                //bit with shift
                numbers[i] >>= 1;
                count--;
            }
        }
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] %= 3;
            singleton += buffer[i] * Math.pow(2, bufferLength - i - 1);
        }
        return singleton;
    }
}
