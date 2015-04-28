package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distance {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] array = new int[5];
		int max;
		int min;
		int distance;
		int minIndex = 0;
		int maxIndex = 0;
		
		System.out.println("Please, enter 5 numbers:");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			array[i] = Integer.parseInt(reader.readLine());
		}
		
		max = array[0];
		min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
				maxIndex = i;
			}
			if (min > array[i]) {
				min = array[i];
				minIndex = i;
			}
		}
		
		System.out.print("You entered: ");
		for (int i : array) {
			System.out.print(i + " ");

		}
		System.out.println();
		System.out.println("Min: " + min);
		System.out.println	("Max: " + max );
		
		for (int i = 0; i < array.length; i++) {
			
		}
		
		distance = maxIndex - minIndex;
		System.out.println	("The distance: " + Math.abs(distance));
		
	}
}
