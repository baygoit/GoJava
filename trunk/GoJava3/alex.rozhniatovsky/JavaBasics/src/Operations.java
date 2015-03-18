/**
 * Created by roznalex on 18.03.2015.
 */
public class Operations {
    public static void main(String[] args) {
        int result = Operations.pow(2, 3);
        System.out.print(result);
    }

    public static int pow(int base, int exp) {
        int result = 1;
        int mask = 1;
        int pow = base;

        for (int i = 0; i < Integer.SIZE; i++) {
            if (i > 0) {
                pow *= pow;
            }
            if ((mask & exp) == mask) {
                result *= pow;
            }
            mask <<= 1;
        }
        return result;
    }
}