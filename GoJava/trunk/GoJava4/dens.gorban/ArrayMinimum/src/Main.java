import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static final int MAX_INTEGER = Integer.MAX_VALUE;
	private static final int ARRAY_MAX_LENGTH = 100;
	private static final String EXIT = "q";
	private static final String COUNT = "c";

	public static void main(String[] args) {
		PrintStream console = System.out;

		console.println("");
		console.println("To exit the program type '" + EXIT + "'");
		console.println("To process input  '" + COUNT + "'");

		Scanner scanIn = new Scanner(System.in);
		while (true) {
			int i;
			int[] anputArray = new int[ARRAY_MAX_LENGTH];			
			for (i = 0; i < ARRAY_MAX_LENGTH; i++) {
				String value = scanIn.next();
				if (value.equalsIgnoreCase(EXIT))
					System.exit(0);
				if (value.equalsIgnoreCase(COUNT))
					break;
				try {
					int element = Integer.parseInt(value);
					anputArray[i] = element;
				} catch (NumberFormatException nfe) {
					console.print(" ignorring ");
					i--;
				} catch (IndexOutOfBoundsException ioobe) {
					console.print(" ignorring ");
					break;
				}
			}
			int[] finalArray = Arrays.copyOfRange(anputArray, 0, i);
			int min1 = findMinIndex(finalArray);
			
			finalArray[min1] = MAX_INTEGER;
			int	min2 = findMinIndex(finalArray);
			
			console.println("Distance between min integers = " + Math.abs(min1 - min2));
		}
	}

	private static int findMinIndex(int[] array) {
		int minIdex = 0;
		int minValue = array.length> 0 ? array[0] : 0;
		for(int index = 0; index< array.length ; index++){
			if (minValue > array[index]) {
				minValue = array[index];
				minIdex = index;
			}
		}		
		return minIdex;		
	}
}

