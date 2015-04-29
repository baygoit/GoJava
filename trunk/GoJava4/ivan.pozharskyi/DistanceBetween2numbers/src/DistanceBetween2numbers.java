import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceBetween2numbers {

	private static final String SEPARATOR = " ";
	private String line;
	private static final String EXIT = "exit";


	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter array of numbers or exit");
				String line = bufferedReader.readLine();
				if (EXIT.equalsIgnoreCase(line)) {
					break;
				}
				int[] numbers = getNumbers(splitLine(line));
				findDistanceBetween2Min(numbers);

			} catch (NumberFormatException e) {
				System.out.println("Wrong enterd line");
				System.out.println("Try again");
			}

		}
		bufferedReader.close();
	}

	private static String[] splitLine(String line) {
		return line.split(SEPARATOR);
	}

	private static int[] getNumbers(String[] words) {
		int numbersLength = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].isEmpty()) {
				numbersLength--;
			}
		}
		int[] numbers = new int[numbersLength];
		for (int i = 0, j = 0; i < words.length || j < numbersLength; i++, j++) {
			if (words[i].isEmpty()) {
				j--;
			} else {
				numbers[j] = Integer.valueOf(words[i]);
			}

		}
		return numbers;
	}

	private static void findDistanceBetween2Min(int[] numbers) {
		int min1 = numbers[0];
		int min1Index = 0;
		int min2, min2Index;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < min1) {
				min1 = numbers[i];
				min1Index = i;
			}

		}
		if (min1Index != 0) {
			min2Index = 0;
			min2 = numbers[0];
		} else {
			min2Index = 1;
			min2 = numbers[1];
		}
		for (int i = 0; i < numbers.length; i++) {
			if (i != min1Index) {
				if (numbers[i] < min2) {
					min2 = numbers[i];
					min2Index = i;
				}
			}
		}

		System.out.println("result: " + Math.abs(min2Index - min1Index)
				+ " MinNumber1: " + min1 + " MinNumber2: " + min2);
	}

}
