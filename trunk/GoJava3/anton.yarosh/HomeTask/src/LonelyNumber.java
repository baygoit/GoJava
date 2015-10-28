/*
 * Algorithm of solving task is following: convert each number to binary format and sum 
 * all numbers bitwise. Then divide each digit by 3 (or other number repetitions).
 * As result, we will receive lonely number in binary format. Last action is to convert it to 
 * decimal format.    
 *  
 */
import java.util.Arrays;

public class LonelyNumber {
    public static void main(String[] args) {
	int lonelyNumber = 0;
	int maxIndex = 0;
	int m[] = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4, 5, 5, 5, 7, 7, 50, 100, 100, 100};

	/* In massive rez bitwise sum will be kept*/
	int rez[] = new int[20];

	for (int i = 0; i < m.length; i++) {
	    int j = 0;
	    int k = m[i];
	    while (k != 0) {
		if (j >= rez.length - 1) {

		    /*if max number from initial massive in binary format 
		     * has more digits than rez length, length of rez will be doubled
		     */
		    rez = Arrays.copyOf(rez, rez.length * 2);
		}

		/*convert numbers to binary format*/
		rez[j] = rez[j] + k % 2;
		k = k / 2;
		j++;
	    }
	    if (j > maxIndex) {

		/*keep max digit index*/
		maxIndex = j;
	    }
	}

	/*lonely number's back conversion to decimal format */
	for (int i = 0; i <= maxIndex - 1; i++) {
	    lonelyNumber = (int) (lonelyNumber + (rez[i] % 3 * Math.pow(2, i)));
	}
	System.out.println(lonelyNumber);
    }
}
