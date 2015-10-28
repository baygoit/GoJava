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
		this.accuracy = accuracy;
		this.dividendWithAccuracy = convert(addAccuracy(dividend));
		this.logger = logger;
	}

	public double calculate() {
		calculateDivide();
		int result = convert(logger.getResult());
		return removeAccuracy(result);
	}

	private void calculateDivide() {
		int currentDivident = 0;
		int index = 0;
		do {
			currentDivident = getNextDigit(currentDivident, index);
			if (!isCorrectDividend(currentDivident)) {
				continue;
			}
			int result = currentDivident / divisor;
			currentDivident -= result * divisor;
			logger.logDivision(result * divisor, currentDivident);
			logger.logResult(result);

		} while (hasNextDigit(index++));
	}

	private int getNextDigit(int currentDivident, int index) {
		int digit = convert(getDigit(dividendWithAccuracy, index));
		logger.logNextDigit(digit, index);
		return currentDivident * RADIX + digit;
	}

	private boolean hasNextDigit(int index) {
		return index < dividendWithAccuracy.length() - 1;
	}

	private boolean isCorrectDividend(int currentDivident) {
		return (currentDivident == 0) || (currentDivident / divisor >= MINIMUM_ALLOW_RESULT);
	}

	private int addAccuracy(int number) {
		return number * (int) Math.pow(RADIX, accuracy);
	}

	private double removeAccuracy(int result) {
		return result / Math.pow(RADIX, accuracy);
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
