import java.util.*;


public class TwoMinDistance {
	
	public static void main(String[] args) {
		
		int[] numbers = readAllNumbers();
		int MinimalNumbersDistance = getMinimalNumbersDistance(numbers);
		System.out.println("Distance is: "+ MinimalNumbersDistance);
	}

	final static int MIN_VALUE = 0;
	final static int SECOND_MIN_VALUE = 1;

	private static int  getMinimalNumbersDistance(int[] numbers) {
		int firstMinValue = 0;
		int secondMinValue = 1;
		for (int currentNumber = 1; currentNumber < numbers.length; currentNumber++) {
			if (numbers[currentNumber] <= numbers[firstMinValue]) {
				secondMinValue = firstMinValue;
				firstMinValue = currentNumber;
			} else if (numbers[currentNumber] < numbers[secondMinValue]) {
				secondMinValue = currentNumber;
			}
		}
		return Math.abs(firstMinValue - secondMinValue);
	}
	
	
	private static int[] readAllNumbers() {
		int[] result = new int[getNumbersAmount()];
		System.out.println("Enter number end press enter or just press enter.");
		for (int index=0; index < result.length; index++) {
			result[index] = readNumber();	
		}
		return result;
	}
	
	private static int getNumbersAmount() {
	System.out.println("Enter amount of numbers you plan to enter.");
	int result = readNumber();
	if (result < 3) {
		System.err.println("Please enter value more then 2. Try again.");
		return getNumbersAmount();
	}
	return result;
	}


	private static int readNumber() {
	Scanner reader = new Scanner(System.in);
	try {
		return reader.nextInt();
	} catch (InputMismatchException e) {
		System.err.println("Please enter number in range from "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE+". Try again.");
		return readNumber();
	}
	}
}
