package ua.com.goit.gojava4.division;

public class DivisionCalculator {
	public static final int RADIX = 10;
	public static final int MINIMUM_ALLOW_RESULT = 1;

	private int accuracy;
	private String dividendWithAccuracy;
	private int divisor;
	Logger logger;

	public DivisionCalculator(int dividend, int divisor, int accuracy, Logger logger) {
		this.divisor = divisor;
		int dividendWithAccuracy = addAccuracy(dividend);
		this.dividendWithAccuracy = convert(dividendWithAccuracy);
		this.accuracy = accuracy;
		this.logger = logger;
	}

	public double calculate() {
		double result = convert(calculateDivide());
		result = removeAccuracy(result);
		return result;
	}
	
	private String calculateDivide() {
		StringBuilder result = new StringBuilder();

		int currentDivident = 0;
		int index = 0;
		do {
			currentDivident = getNextDigit(currentDivident, index);
			if (!isCorrectDividend(currentDivident)) {
				continue;
			}
			result.append(getDivide(currentDivident));
		} while (hasNextDigit(index++));

		return result.toString();
	}
	
	private int getDivide(int currentDivident) {
		int result = currentDivident / divisor;
		currentDivident -= result * divisor;
		//TO DO:
		//logger.log(SMTH);
		return result;
	}

	private boolean hasNextDigit(int index) {
		if (index >= dividendWithAccuracy.length()) {
			return false;
		}
		return true;
	}

	private int getNextDigit(int currentDivident, int index) {
		int result = currentDivident;
		result *= RADIX;
		result += convert(getDigit(dividendWithAccuracy, index));			
		return result;
	}
	
	private boolean isCorrectDividend(int currentDivident) {
		return (currentDivident == 0) || (currentDivident / divisor >= MINIMUM_ALLOW_RESULT);
	}

	private int addAccuracy(int number) {
		return (int) changeAccuracy(number, RADIX);
	}

	private double removeAccuracy(double result) {
		return changeAccuracy(result, 1 / RADIX);
	}

	private double changeAccuracy(double number, int radix) {
		double result = number;
		for (int i = 0; i < accuracy; i++) {
			result *= radix;
		}
		return result;
	}

	private String getDigit(String number, int index) {
		return number.substring(index, index + 1);
	}

	private String convert(int number) {
		return "" + number;
	}

	private int convert(String number) {
		return Integer.parseInt(number);
	}
}
