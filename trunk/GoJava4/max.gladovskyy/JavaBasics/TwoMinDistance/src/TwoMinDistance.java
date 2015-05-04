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
		int[] minValues = new int[]{MIN_VALUE, SECOND_MIN_VALUE};
		for (int currentNumber = 1; currentNumber < numbers.length; currentNumber++) {
			processCurrentNumber(numbers, minValues, currentNumber);
		}
		return Math.abs(minValues[MIN_VALUE] - minValues[SECOND_MIN_VALUE]);
	}


	private static void processCurrentNumber(int[] numbers, int[] minValues, int currentNumber) {
		if (numbers[currentNumber] <= numbers[minValues[MIN_VALUE]]) {
			minValues[SECOND_MIN_VALUE] = minValues[MIN_VALUE];
			minValues[MIN_VALUE] = currentNumber;
		} else if (numbers[currentNumber] < numbers[minValues[SECOND_MIN_VALUE]]) {
			minValues[SECOND_MIN_VALUE] = currentNumber;
		}
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
