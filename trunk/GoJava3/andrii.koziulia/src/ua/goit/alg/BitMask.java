package ua.goit.alg;

/**
 * Created by Alex on 20.03.2015.
 */
public class BitMask {

    public static void main(String[] args) {
        System.out.println(myPow(2, 8));
    }

    public static long myPow(long root, long degree) {
        long mask = 1;
        long result = 1;
        long localPow = root;
        for (int i=0;i<32;i++) {
            if ((degree & mask) == mask) {
                result *= localPow;
            }
            localPow *= localPow;
            mask <<= 1;
        }
        return result;
    }
}
