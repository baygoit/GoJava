import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) throws IOException {
        int[] randomNumbers = makingRandomArray();
		System.out.println("Random array: " + Arrays.toString(randomNumbers));
		System.out.println("Sorted random array: " + Arrays.toString(sort(randomNumbers)));
	}

	public static int[] makingRandomArray() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter length of random array");

		int[] randomNums = new int[Integer.parseInt(reader.readLine())];
		reader.close();

		for (int i = 0; i < randomNums.length; i++)
			randomNums[i] = (int) (Math.random() * 100);
		return randomNums;
	}

	public static int[] sort(int[] fullArray) {
		if (fullArray.length < 2)
			return fullArray;
		int halfOfArray = fullArray.length / 2;
		int[] leftPartOfArray = Arrays.copyOfRange(fullArray, 0, halfOfArray);
		int[] rightPartOfArray = Arrays.copyOfRange(fullArray, halfOfArray, fullArray.length);
		return merge(sort(leftPartOfArray), sort(rightPartOfArray));
	}

	public static int[] merge(int[] firstHalfOfArray, int[] secondHalfOfArray) {
		int arrayLength = firstHalfOfArray.length + secondHalfOfArray.length;
		int[] newArray = new int[arrayLength];
		int indexOfFirstHalf = 0;
		int indexOfSecondHalf = 0;
		for (int i = 0; i < arrayLength; i++) {
			if (indexOfFirstHalf == firstHalfOfArray.length) {
				newArray[i] = secondHalfOfArray[indexOfSecondHalf++];
			} else if (indexOfSecondHalf == secondHalfOfArray.length) {
				newArray[i] = firstHalfOfArray[indexOfFirstHalf++];
			} else {
				if (firstHalfOfArray[indexOfFirstHalf] < secondHalfOfArray[indexOfSecondHalf]) {
					newArray[i] = firstHalfOfArray[indexOfFirstHalf++];
				} else {
					newArray[i] = secondHalfOfArray[indexOfSecondHalf++];
				}
			}
		}
		return newArray;
	}

}
