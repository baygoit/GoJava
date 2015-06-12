import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceBetween2numbers {

	private static final int FIRSTINDEX = 0;
	private static final int EMPTYINDEX = -1;
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
				System.out.println("Distance between 2 min numbers:");
				System.out.println(findDistanceBetween2Min(numbers));

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

		int numbersLength = amountNumbers(words);
		int[] numbers = new int[numbersLength];
		for (int indexWord = 0, indexNumbers = 0; indexWord < words.length; indexWord++, indexNumbers++) {
			if (words[indexWord].isEmpty()) {
				indexNumbers--;
			} else {
				numbers[indexNumbers] = Integer.valueOf(words[indexWord]);
			}

		}
		return numbers;
	}

	private static int amountNumbers(String[] words) {
		int numbersLength = words.length;
		for (int indexWord = 0; indexWord < words.length; indexWord++) {
			if (words[indexWord].isEmpty()) {
				numbersLength--;
			}
		}

		return numbersLength;
	}
	private static int indexOfMinNumber(int[] numbers,int indexMinNumber){
		int result;
		if(indexMinNumber!=FIRSTINDEX){
			result = FIRSTINDEX;
		}
		else{
			result = FIRSTINDEX+1;
		}
		if(indexMinNumber == EMPTYINDEX){
			result = FIRSTINDEX;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (i != indexMinNumber) {
				if (numbers[i] <numbers[result]) {
					numbers[result] = numbers[i];
					result = i;
				}
			}
		}
		return result;
				
	}
	private static int findDistanceBetween2Min(int[] numbers) {

		int indexMinNumber1 = indexOfMinNumber(numbers,EMPTYINDEX);
		int indexMinNumber2 = indexOfMinNumber(numbers,indexMinNumber1);
		return Math.abs(indexMinNumber1 - indexMinNumber2);
	
	}

}
