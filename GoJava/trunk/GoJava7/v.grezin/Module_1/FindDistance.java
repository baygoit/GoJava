package com.gmail.grezin.v;
/*
 * Task 2: Find the distance between two smallest elements in array. 
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FindDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[20];
		int mode;
		String text;
		
		System.out.println("Please choose how generate array 0- manual mode, 1-automatical");
		mode = scan.nextInt();
		scan.nextLine();
		
		if (mode == 0) {
			System.out.println("Enter array");
			text = scan.nextLine();
			numbers = getArray(text);
		} else {
			numbers = randomArray(numbers);
		}
		
		minDistance(numbers);
		scan.close();

	}

	public static void minDistance(int[] numbers) {
		int distance = 0;
		int resultDistance = 0;
		int minElement1; 
		int minElement2;
		int elementN1 = -1, elementN2 = -1;
		int[] sorted = new int[numbers.length];
		
		System.arraycopy(numbers, 0, sorted, 0, numbers.length);
		Arrays.sort(sorted);
		
		minElement1 = sorted[0];
		minElement2 = sorted[1]; 
		
		for (int i = 0; i < numbers.length; i++) {
			if (minElement1 != minElement2) {
				if (numbers[i] == minElement1) {
					elementN1 = i;
				}
				if (numbers[i] == minElement2) {
					elementN2 = i;
				}
				if ((elementN1 != -1) && (elementN2 != -1)) {
					resultDistance = Math.abs(elementN2 - elementN1);
				}
				if ((resultDistance < distance) && (distance != 0)) {
					distance = resultDistance;
				}
				if (distance == 0) {
					distance = resultDistance;
				}
			} else {
				if (numbers[i] == minElement1 && elementN1 == -1)
					elementN1 = i;
				if (numbers[i] == minElement1 && elementN2 != -1 && elementN2 != i)
					elementN1 = i;
				if (numbers[i] == minElement1 && elementN1 != -1 && elementN1 != i)
					elementN2 = i;
				if (elementN1 != -1 && elementN2 != -1)
					resultDistance = Math.abs(elementN2 - elementN1);
				if (resultDistance < distance)
					distance = resultDistance;
				if (distance == 0)
					distance = resultDistance;
			}
		}
		System.out.println("Minimums are " + minElement1 + " and " + minElement2);
		System.out.println("Distance is " + distance);
	}

	public static int[] randomArray(int[] numbers) {
		Random rn = new Random();
		int[] numbers1 = new int[numbers.length];
		
		for (int i = 0; i < numbers1.length; i++) {
			numbers1[i] = rn.nextInt(10);
			System.out.print(numbers1[i] + " ");
		}
		System.out.println();
		return numbers1;
	}

	public static int[] getArray(String text) {
		String[] textArray = { "" };
		int[] numbers;
		int position;
		
		position = text.indexOf(" ");
		if (position != -1) {
			textArray = text.split("[ ]");
		}
		position = text.indexOf(",");
		if (position != -1) {
			textArray = text.split("[,]");
		}
		position = text.indexOf(";");
		if (position != -1) {
			textArray = text.split("[;]");
		}
		numbers = new int[textArray.length];
		for (int i = 0; i < textArray.length; i++) {
			numbers[i] = Integer.parseInt(textArray[i]);
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		return numbers;
	}
}
