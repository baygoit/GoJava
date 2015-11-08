package ua.com.goit.gojava4.division;

public class Logger {
	private StringBuilder result = new StringBuilder();
	private StringBuilder log = new StringBuilder();
	private String spaces = "";

	public String getResult() {
		return result.toString();
	}

	public String composeAnswer(double result, int dividend, int divisor) {
		StringBuilder answer = new StringBuilder();
		answer.append(dividend);
		answer.append("   | ");
		answer.append(divisor);
		answer.append("\r\n   | ");
		answer.append(result);
		answer.append("");
		answer.append(getLog());
		return answer.toString();
	}

	public void logDivision(int divisor, int currentDivident) {
		if (divisor > 0) {
			logln(divisor);
		}
		addSpaces();
		if (currentDivident > 0) {
			logln(currentDivident);
		}
	}

	public void logNextDigit(int digit, int index) {
		if (digit > 0 && index > 0) {
			append(digit);
		}
	}

	public void logResult(int a) {
		result.append(a);
	}

	private String getLog() {
		return log.toString();
	}

	private void logln(int a) {
		log.append("\r\n");
		log.append(spaces);
		log(a);
	}

	private void addSpaces() {
		spaces += " ";
	}

	private void log(int a) {
		log.append(a);
	}

	private void append(int a) {
		log.append(a);
	}
}
