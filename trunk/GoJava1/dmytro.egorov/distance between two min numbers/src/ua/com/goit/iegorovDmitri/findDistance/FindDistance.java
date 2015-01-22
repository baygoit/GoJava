package ua.com.goit.iegorovDmitri.findDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindDistance {
	public static void main(String[] args) throws IOException {
		BufferedReader builder = new BufferedReader(new
		InputStreamReader(System.in));
		String string = builder.readLine();
		int minNumber = Integer.MAX_VALUE;
		int indexOfFirstMin = 0, indexOfSecondMin = 0;

		String[] strings = string.split(" ");
		int[] numbers = new int[strings.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(strings[i]);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < minNumber) {
				minNumber = numbers[i];
				indexOfFirstMin = i;
			}
		}
		minNumber = Integer.MAX_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			if ((numbers[i] < minNumber)&&(numbers[i] > numbers[indexOfFirstMin])) {
				minNumber = numbers[i];
				indexOfSecondMin = i;
			}
		}

		System.out.println(Math.abs(indexOfFirstMin-indexOfSecondMin));
	}
}
