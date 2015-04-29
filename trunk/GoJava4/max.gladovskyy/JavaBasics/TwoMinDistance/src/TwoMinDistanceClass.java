import java.io.*;
import java.util.*;


public class TwoMinDistanceClass {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Integer> numbers = readAllNumbers();
		int MinimalNumbersDistance = getMinimalNumbersDistance(numbers);
		System.out.println("Distance is: "+ MinimalNumbersDistance);
	}

	private static final int MAX_INT_DIGITS_COUNT = 10;

	private static int  getMinimalNumbersDistance(ArrayList<Integer> numbers) {
		int firstNumberValue = numbers.get(0);
		int secondNumberValue = numbers.get(1);
		int firstNumberPosition = 0;
		int secondNumberPosition = 1;
		
		for (int currentPosition = 1; currentPosition < numbers.size(); currentPosition++) {
			if (numbers.get(currentPosition) < firstNumberValue) {
				secondNumberValue = firstNumberValue;
				secondNumberPosition = firstNumberPosition;
				firstNumberValue = numbers.get(currentPosition);
				firstNumberPosition = currentPosition;
			} else if (numbers.get(currentPosition) >= firstNumberValue && numbers.get(currentPosition) < secondNumberValue) {
				secondNumberValue = numbers.get(currentPosition);
				secondNumberPosition = currentPosition;
			}
		}
		return Math.abs(firstNumberPosition - secondNumberPosition);
	}
	
	
	private static ArrayList<Integer> readAllNumbers() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(true) {
			String number = readConsoleOneTime();
			if(number.equals("")) {
				break;
			}
			if (!validateNumber(number)) {
				continue;
			}
			result.add(Integer.parseInt(number));	
		}
		checkNumbersQuantity(result);
		return result;
	}

	private static void checkNumbersQuantity(ArrayList<Integer> result) {
		if (result.size() < 2) {
			System.err.println("You entered not enough numbers, minimum 2 needed.");
			System.exit(0);
		}
		
	}


	private static String readConsoleOneTime() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number end press enter or just press enter if you finish");
		try {
			return reader.readLine();
		} catch (IOException e) {
			System.err.println("You entered incorrect data (integer needed)");
		}
		return null;
	}

	private static boolean validateNumber(String number) {
		for (Character digit: number.toCharArray()) {
			if (!Character.isDigit(digit)) {
				System.err.println(digit+" is not a digit. Try Again.");
				return false;
			}
		}
		if (number.length() > MAX_INT_DIGITS_COUNT || Long.parseLong(number) > Integer.MAX_VALUE) {
			System.err.println(number+" is to big. Maximim is "+Integer.MAX_VALUE+" digits in number");
			return false;
		}
		return true;
	}
}
