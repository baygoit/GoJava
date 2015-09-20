package ua.goit.alg.lonelynum;

public class LonelyNumber {

    public static int search(int[] numArray) {
	int[] bit = new int[32];

	for (int num : numArray) {
	    for (int i = 0; i < bit.length; i++) {
		int numForBits = 1 << i;
		if ((num & numForBits) > 0) {
		    bit[i] += 1; 
		}
	    }
	}

	int res = 0;
	for (int i = 0; i < bit.length; i++) {
	    if (bit[i] % 3 == 1) {
		res |= 1 << i;
	    }
	}
	
	return res;
    }
}
