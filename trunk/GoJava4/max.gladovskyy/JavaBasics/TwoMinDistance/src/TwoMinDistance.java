import java.util.*;


public class TwoMinDistanceClass {
	
	public static void main(String[] args) {
		
		int[] numbers = readAllNumbers();
		int MinimalNumbersDistance = getMinimalNumbersDistance(numbers);
		System.out.println("Distance is: "+ MinimalNumbersDistance);
	}

	final static int MIN_VALUE = 0;
	final static int SECOND_MIN_VALUE = 1;
	final static int MIN_POSITION = 2;
	final static int SECOND_MIN_POSITION = 3;
	final static int MIN_VALUES_INFO_ARRAY_SIZE = 4;

	private static int  getMinimalNumbersDistance(int[] numbers) {
		int[] minValuesInfo = initializeMinValuesInfo(numbers);
		for (int currentPosition = 1; currentPosition < numbers.length; currentPosition++) {
			if (numbers[currentPosition] <= minValuesInfo[MIN_VALUE]) {
				shiftMinValuesInfo(numbers[currentPosition], currentPosition, minValuesInfo);
			} else if (numbers[currentPosition] < minValuesInfo[SECOND_MIN_VALUE]) {
				replaceSecondMinValueInfo(numbers[currentPosition], currentPosition, minValuesInfo);
			}
		}
		return Math.abs(minValuesInfo[SECOND_MIN_POSITION] - minValuesInfo[MIN_POSITION]);
	}


	private static int[] initializeMinValuesInfo(int[] numbers) {
		int[] result = new int[MIN_VALUES_INFO_ARRAY_SIZE];
		result[MIN_VALUE] = numbers[0];
		result[SECOND_MIN_VALUE] = numbers[1];
		result[MIN_POSITION] = 0;
		result[SECOND_MIN_POSITION] = 1;
		return result;
	}


	private static void replaceSecondMinValueInfo(int newValue, int newPosition, int[] minValuesInfo) {
		minValuesInfo[SECOND_MIN_VALUE] = newValue;
		minValuesInfo[SECOND_MIN_POSITION] = newPosition;
	}


	private static void shiftMinValuesInfo(int newValue, int newPosition, int[] minValuesInfo) {
		minValuesInfo[SECOND_MIN_VALUE] = minValuesInfo[MIN_VALUE];
		minValuesInfo[SECOND_MIN_POSITION] = minValuesInfo[MIN_POSITION];
		minValuesInfo[MIN_VALUE] = newValue;
		minValuesInfo[MIN_POSITION] = newPosition;
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
