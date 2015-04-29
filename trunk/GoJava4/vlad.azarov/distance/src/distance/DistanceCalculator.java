
package distance;

/*“во€ задача создать консольное приложение, которое принимало бы на вход
 * р€д чисел и выводило рассто€ние между двум€ наименьшими.
 * Ќапример, дано р€д чисел: "23 45 34 12 45 4 38 56 2 49 100".
 * Ќаименьшие числа в нем 2 и 4. –ассто€ние между ними - 3.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceCalculator {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int[] numbers = new int[10];
	
		System.out.println("Please enter 10 numbers: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(reader.readLine());
		}
		
		System.out.print("You entered: ");
		for (int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		DistanceCalculator yourTry = new DistanceCalculator();
		yourTry.toFindMinDistanceBetween(numbers);
	
	}

	private void toFindMinDistanceBetween(int[] numbers) {
		int distance;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int firstMinIndex = -1;
		int secondMinIndex = -1;
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < firstMin) {
				secondMin = firstMin;
				secondMinIndex = firstMinIndex;
				firstMin = numbers[i];
				firstMinIndex = i;
			} else if (numbers[i] < secondMin) {
				secondMin = numbers[i];
				secondMinIndex = i;
			}	
		}
		
		distance = Math.abs(firstMinIndex - secondMinIndex);
		System.out.println("First minimum number in array is: " + firstMin + " at index[" + firstMinIndex + "]");
		System.out.println("Second minimum number in array is: " + secondMin + " at index[" + secondMinIndex + "]");
		System.out.println("The distance between them is: " + distance);

	}	
}