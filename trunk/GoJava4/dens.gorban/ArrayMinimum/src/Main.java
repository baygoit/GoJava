import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static final int ARRAY_MAX = 100;
	private static final String EXIT = "q";
	private static final String COUNT = "c";

	public static void main(String[] args) {
		PrintStream console = System.out;

		console.println("Эта программа определяет расстояние между двумя наименьшими  положительніми числами в массиве");
		console.println("Максимальное число введеннх єлементов в массив: "
				+ ARRAY_MAX);
		console.println("для завершеня программы введите '" + EXIT + "'");
		console.println("для вычесления разницы индексов введите '" + COUNT + "'");

		Scanner scanIn = new Scanner(System.in);
		while (true) {
			int i;
			int[] arr = new int[ARRAY_MAX];			
			for (i = 0; i < ARRAY_MAX; i++) {
				String value = scanIn.next();
				if (value.equalsIgnoreCase(EXIT))
					System.exit(0);
				if (value.equalsIgnoreCase(COUNT))
					break;
				try {
					int element = Integer.parseInt(value);
					arr[i] = element;
				} catch (NumberFormatException nfe) {
					console.print(" ignorring ");
					i--;
				} catch (IndexOutOfBoundsException ioobe) {
					console.print(" ignorring ");
					break;
				}
			}
			int[] arrRange = Arrays.copyOfRange(arr, 0, i);
			int min1 = findMinIndex(arrRange);
			
			arrRange[min1] = Integer.MAX_VALUE;
			int	min2 = findMinIndex(arrRange);
			
			console.println("Distance between min integers = " + Math.abs(min1 - min2));
		}
	}

	private static int findMinIndex(int[] arr) {
		int minIdex = 0;
		int minValue = arr.length> 0 ? arr[0] : 0;
		for(int a = 0; a< arr.length ; a++){
			if (minValue > arr[a]) {
				minValue = arr[a];
				minIdex = a;
			}
		}		
		return minIdex;		
	}
}

