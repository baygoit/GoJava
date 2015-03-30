import java.util.Arrays;
import java.util.Scanner;
public class MinNumber {

    /*
     * Starting from first index comparing with each next element.
     * Managing two gap - between different elements and between equal minimum elements.
     *    
     * 
     */

    public static void main(String[] args) {
	String input="6 5 3 1 6 2 1 5 6 3 1 1 0 -6";
	String[]m = input.split(" ");
	int []rez = new int[m.length];
	for (int i = 0; i < m.length; i++) {
	    rez[i] = Integer.parseInt(m[i]);
	}
	int minElement = rez[0];
	int minIndex = 0;
	int minGapIndex = 1;
	int minGap = Math.abs(rez[minIndex] - rez[minGapIndex]);
	int equalIndexGap = Integer.MAX_VALUE;
	int finalGap = 0;
	for (int i = minIndex + 1; i < rez.length; i++) {

	    /* Searching for the minimum element*/
	    if (minElement > rez[i]) {
		minGap = minElement - rez[i];
		minElement = rez[i];
		minGapIndex = minIndex;
		minIndex = i;
		equalIndexGap = Integer.MAX_VALUE;
	    } else if (minElement == rez[i]) {                      //Calculating and storing the equalIndexGap if find same minimum element		    
		if (Math.abs(minIndex - i) < equalIndexGap) {
		    equalIndexGap = Math.abs(minIndex - i); 	    // Storing new gap if it less then current 
		    minIndex = i;  			    	    // Shift minimum element index forward
		} else {
		    minIndex = i;  			    	    // Shift minimum element index forward  						
		}
	    } else {
		if (Math.abs(minElement - rez[i]) < minGap) {       //Searching for nearest next value after minimum
		    minGap = Math.abs(minElement - rez[i]);
		    minGapIndex = i;
		} else if (Math.abs(minElement - rez[i]) == minGap) {  //If next value after minimum is more then one, calculating and storing nearest
		    if (Math.abs(minIndex - minGapIndex) > Math.abs(minIndex - i)) {
			minGapIndex = i;
		    }
		}
	    }
	}

	/* Printing result */
	if (equalIndexGap == Integer.MAX_VALUE) {
	    finalGap = Math.abs(minIndex - minGapIndex); 
	    System.out.println("Min element: " + rez[minIndex] + ", next closest value: " + rez[minGapIndex]);
	} else {
	    finalGap = equalIndexGap;
	    System.out.println("Minimal repeated value: " + rez[minIndex]);			
	}
	System.out.println("Minimal distance: " + finalGap);
    }
}
