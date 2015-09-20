/**
 * Created by root on 12.03.2015.
 */
public class LonelySymbol {
    public static void main (String[] args) {
        int[] numbers = {15, 3, 15, 4, 3, 7, 15, 3, 4, 4};
        int[] bitCounter = new int[32];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int counter = 0;
            while (numbers[i] > 0) {
                if ((numbers[i] & 1 ) == 1) {
                    bitCounter[bitCounter.length - 1 - counter] += 1;
                }
                numbers[i] >>=1;
                counter++;
            }
        }

        for (int i = 0; i < bitCounter.length; i++) {
            builder.append(bitCounter[i] % 3);
        }

        System.out.println(Integer.parseInt(builder.toString(), 2));
    }
}


