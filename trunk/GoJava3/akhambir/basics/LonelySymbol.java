/**
 * Created by root on 12.03.2015.
 */
public class LonelySymbol {
    public static void main (String[] args) {
        int[] numbers = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4};
        int lonely = numbers[0]|numbers[1]|numbers[2]|numbers[3]|numbers[4]|numbers[5]|numbers[6]|numbers[7]|numbers[8]|numbers[9];
        System.out.println(lonely);
    }
}


