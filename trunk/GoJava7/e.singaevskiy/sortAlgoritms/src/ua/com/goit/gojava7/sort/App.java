package ua.com.goit.gojava7.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ua.com.goit.gojava7.sort.sorting.BoubleSort;
import ua.com.goit.gojava7.sort.sorting.MergeSort;
import ua.com.goit.gojava7.sort.sorting.QuickSort;
import ua.com.goit.gojava7.sort.sorting.SelectionSort;
import ua.com.goit.gojava7.sort.sorting.SortingAlgoritm;

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
