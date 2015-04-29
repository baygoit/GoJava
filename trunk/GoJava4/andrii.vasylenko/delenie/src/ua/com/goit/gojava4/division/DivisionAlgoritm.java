package ua.com.goit.gojava4.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisionAlgoritm {
	public static final int ACCURACY = 6;
	public static final int CORRECT_NUMBER_ARGUMENTS = 2;
	public static final String DIVISION_SYMBOL = "/";

	private int dividend, divisor;

	public DivisionAlgoritm(String formula) throws NumberFormatException {
		String[] numbers = split(formula);
		dividend = convert(numbers[0]);
		divisor = convert(numbers[1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.println("Input formula (or 'exit'):");
				String line = reader.readLine();
				if ("exit".equalsIgnoreCase(line)) {
					break;
				}

				System.out.println(new DivisionAlgoritm(line).getDivisionAnswer());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect formula! Try again please");
			}
		}

		reader.close();
	}

	public String getDivisionAnswer() {
		Logger logger = new Logger();
		DivisionCalculator calculator = new DivisionCalculator(dividend, divisor, ACCURACY, logger);
		double result = calculator.calculate();
		return composeAnswer(result, logger);
	}

	private String composeAnswer(double result, Logger logger) {
		StringBuilder answer = new StringBuilder();
		answer.append(dividend);
		answer.append(divisor);
		answer.append(result);
		answer.append(logger.getLog());
		return answer.toString();
	}

	private String[] split(String formula) throws NumberFormatException {
		String[] numbers = formula.split(DIVISION_SYMBOL);
		if (!check(numbers)) {
			throw new NumberFormatException();
		}
		return numbers;
	}

	private boolean check(String[] numbers) {
		return numbers.length == CORRECT_NUMBER_ARGUMENTS;
	}

	private int convert(String number) throws NumberFormatException {
		return Integer.parseInt(number);
	}
}
