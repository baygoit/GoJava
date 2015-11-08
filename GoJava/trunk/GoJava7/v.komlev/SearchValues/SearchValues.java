package logic;

import java.util.Random;

public class SearchValues {

	static int[] array = new int[10];
	static int[] arrayInt = { 10, 7, 2, 9, 20, 3 };
	static Random rnd = new Random();
	static int ind2 = 0, ind1 = 0, min1 = 0;
	static int tmp = 0;

	public static int[] fillArray() {
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt();
		}
		return array;
	}

	public static void viewArray() {
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void sortArray() {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				tmp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = tmp;
			}
		}
	}

	public static void searchValues() {
		// Находит расстояние между двумя наименьшими значениями

		for (int i = 0; i < arrayInt.length; i++) {

			if (min1 == 0) {
				min1 = arrayInt[i];
			}
			if (min1 > arrayInt[i]) {
				min1 = arrayInt[i];
				ind1 = i;
			}

		}

		min1 = 0;

		for (int i = 0; i < arrayInt.length; i++) {
			if (min1 == 0) {
				min1 = arrayInt[i];
			}

			if (ind1 == i) {
				continue;
			} else if (min1 > arrayInt[i]) {
				min1 = arrayInt[i];
				ind2 = i;
			}

		}

		System.out.println("The distance between the two lower values "+(ind2-ind1));
	}

	public static void main(String[] args) {

		searchValues();

	}
}
