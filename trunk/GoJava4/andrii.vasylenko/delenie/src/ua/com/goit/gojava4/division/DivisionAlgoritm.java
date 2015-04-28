package ua.com.goit.gojava4.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisionAlgoritm {

	private int accuracy = 6;
	private int dividend, divisor;
	private String dividendWithAccuracy;
	
	public DivisionAlgoritm(String formula) throws NumberFormatException {
		String[] numbers = split(formula);
		dividend = convert(numbers[0]);
		divisor = convert(numbers[1]);
		dividendWithAccuracy = addAccuracy(numbers[0]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			System.out.println("Input formula:");
			String formula = reader.readLine();
			new DivisionAlgoritm(formula).showResult();
		} catch (NumberFormatException e) {
			System.out.println("Incorrect formula!");
			return;
		} finally {
			reader.close();
		}
	}

	public void showResult() {
		StringBuilder result = new StringBuilder();
		StringBuilder log = new StringBuilder();
		StringBuilder spaces = new StringBuilder();
		int currentNumber = 0;
		
		for (int index = 0; hasNextDigit(index); index++) {
			getNextDigit(currentNumber, index, spaces, log);
			calcResult(result, currentNumber, spaces, log);
		}
		
		outputResult(result, log);
	}
	
	
	private boolean hasNextDigit(int index)
	{
		if (index >= dividendWithAccuracy.length()) {
			return false;
		}
		return true;
	}

	private void calcResult(StringBuilder sResult, int currentNumber, StringBuilder spaces, StringBuilder log) {
		int localResult = currentNumber / divisor;
		sResult.append(localResult);
		localResult *= divisor;
		log.append(spaces.toString() + localResult + "\n");
		spaces.append(" ");
		currentNumber -= localResult;
	}
	
	private int getNextDigit(int currentNumber, int index, StringBuilder spaces, StringBuilder log) {
		if (!hasNextDigit(index)) {
			log.append(spaces.toString() + currentNumber + "\n");
			return currentNumber;
		}
		currentNumber *= 10;
		currentNumber += Integer.parseInt(dividendWithAccuracy.substring(index,
				index + 1));
		
		if (currentNumber != 0 && currentNumber / divisor < 1) {
			getNextDigit(currentNumber, ++index, spaces, log);
		}
		if (spaces.length() > 0) {
			log.append(spaces.toString() + currentNumber + "\n");
		}
		return currentNumber;
	}
	
	private void outputResult(StringBuilder sResult, StringBuilder log) {
		int number1 = this.dividend;
		double localResult = Integer.parseInt(sResult.toString());
		for (int i = 0; i < accuracy; i++) {
			number1 /= 10;
			localResult /= 10;
		}
		System.out.println(number1 + " | " + divisor);
		//System.out.println(spaces.toString() + "  |" + localResult);
		System.out.println(log.toString());
	}
	private String[] split(String formula) throws NumberFormatException {
		String[] numbers = formula.split("/");
		check(numbers);
		return numbers;
	}

	private void check(String[] numbers) throws NumberFormatException {
		if (numbers.length != 2) {
			throw new NumberFormatException();
		}
		// try to:
		convert(numbers[0]);
		convert(numbers[1]);
	}

	private String addAccuracy(String number) {
		String result = number;
		for (int i = 0; i < accuracy; i++) {
			this.dividendWithAccuracy += "0";
		}
		return result;
	}

	private int convert(String number) throws NumberFormatException {
		return Integer.parseInt(number);
	}

}
