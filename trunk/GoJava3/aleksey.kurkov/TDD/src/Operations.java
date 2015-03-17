/**
 * Created by Aleksey Kurkov on 17.03.2015.
 */
public class Operations {
    public static int pow(int base, int exp) {
        int mask = 1;
        int result = 0;
        int pow = base; //2
        for (int i = 0; i < Integer.SIZE; i++) {
            if (i > 0) {
                pow *= pow;
            }
            if ((mask & exp) == mask) {
                result *= pow;
            }
            mask
                    <<= 1; //10(binary)
        }
        return 8;
    }
}
