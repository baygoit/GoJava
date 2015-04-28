import java.io.*;
import java.util.*;


public class TwoMinDistanceClass {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Integer> numbers = readAllNumbers();
		int MinimalNumbersDistance = getMinimalNumbersDistance(numbers);
		System.out.println("Distance is: "+ MinimalNumbersDistance);
	}


	private static int  getMinimalNumbersDistance(ArrayList<Integer> numbers) {
		int aNumberValue = numbers.get(0);
		int bNumberValue = numbers.get(1);
		int aNumberPosition = 0;
		int bNumberPosition = 1;
		
		for (int currentPosition = 1; currentPosition < numbers.size(); currentPosition++) {
			if (numbers.get(currentPosition) < aNumberValue) {
				bNumberValue = aNumberValue;
				bNumberPosition = aNumberPosition;
				aNumberValue = numbers.get(currentPosition);
				aNumberPosition = currentPosition;
			} else if (numbers.get(currentPosition) >= aNumberValue && numbers.get(currentPosition) < bNumberValue) {
				bNumberValue = numbers.get(currentPosition);
				bNumberPosition = currentPosition;
			}
		}
		return Math.abs(aNumberPosition - bNumberPosition);
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
			System.err.println("You enteret not enough numbers, minimum 2 needed.");
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
		return true;
	}


}
