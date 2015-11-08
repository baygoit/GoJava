package com.sin.eugene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sin.eugene.sorting.BoubleSort;
import com.sin.eugene.sorting.MergeSort;
import com.sin.eugene.sorting.QuickSort;
import com.sin.eugene.sorting.SelectionSort;
import com.sin.eugene.sorting.SortingAlgoritm;

public class App {

	public static void main(String[] args) {
		
		int arraySize;
		Scanner inputReader = new Scanner(System.in);
		List<SortingAlgoritm> algoritms = getSortingAlgoritms();

		do {
			System.out.println("Enter array size or 0 for exit");
			arraySize = inputReader.nextInt();

			if (arraySize > 0) {
				sortUsingAlgoritms(algoritms, arraySize);
			}

		} while (arraySize > 0);

		inputReader.close();

	}

	private static void sortUsingAlgoritms(List<SortingAlgoritm> algoritms, int arraySize) {
		for (SortingAlgoritm algoritm : algoritms) {
			int[] array = Util.randomArray(arraySize);
			long start = System.nanoTime();
			algoritm.sort(array);
			long finish = System.nanoTime();
			System.out.printf("%s for array[%d] finished in %,d nanoseconds\n", algoritm.getName(), arraySize,
					finish - start);
			if (arraySize <= 20) {
				System.out.println(Arrays.toString(array));
			}
		}
	}

	private static List<SortingAlgoritm> getSortingAlgoritms() {
		List<SortingAlgoritm> algoritms = new ArrayList<>();
		algoritms.add(new BoubleSort());
		algoritms.add(new QuickSort());
		algoritms.add(new SelectionSort());
		algoritms.add(new MergeSort());

		return algoritms;
	}

}
