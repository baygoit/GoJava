package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.List;

/**
 * The class which implements the long division calculations
 * and visualization
 * 
 * @version 3.0 17 Mar 2015
 * @author Sergey Poznyak
 */
public class Division {

	private List<StringBuilder> divisionVisualisation
	                            = new ArrayList<StringBuilder>();

	private int dividend;

	private int divisor;

	private StringBuilder quotient = new StringBuilder();

	private int indent;

	private int transitionalDividend;

	private int transitionalQuotient;

	private int transitionalProduct;

	private int transitionalRemainder;

	public Division(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
	}
	
	/**
	 * Divides numbers.
	 * 
	 * @throws LongDivisionException for incorrect parameters
	 */
	public synchronized String divide() throws LongDivisionException {
		if (divisor == 0) {
			throw new LongDivisionException("Divisor can't be equal to 0.");
		}
		if (dividend < 0 || divisor < 0) {
			throw new LongDivisionException("Both divisor and dividend"
					                        + "should be greater than 0.");
		}
		indent++;
		writeDivisionValue(dividend + "|" + divisor, indent);
		String dividendString = String.valueOf(dividend);
		int indexNextDigit = 0;
		while (indexNextDigit < dividendString.length()) {
			transitionalDividend = transitionalRemainder * 10
					+ Integer.parseInt(dividendString.substring(indexNextDigit,
							                          indexNextDigit + 1));
			indexNextDigit++;
			transitionalQuotient = transitionalDividend/divisor;
			quotient.append(transitionalQuotient);
			transitionalProduct = transitionalQuotient * divisor;
			transitionalRemainder = transitionalDividend - transitionalProduct;
			writeDivisionCycle(transitionalDividend, transitionalProduct,
					           transitionalRemainder);
		}
		if (transitionalRemainder != 0) {
			divideDecimals();
		}
		if (transitionalRemainder == 0) {
			indent--;
		}
		writeDivisionValue("" + transitionalRemainder, indent);
		if (quotient.charAt(0) == '0') {
			int zeroCounter = 0;
			int i = 0;
			while (quotient.charAt(i) == '0') {
				zeroCounter++;
				i++;
			}
			if (quotient.charAt(i) == '.') {
				zeroCounter--;
			}
			quotient.delete(0, zeroCounter);
		}
		for (int i = 0; i < dividendString.length() - 1; i++) {
			divisionVisualisation.get(1).append(" ");
		}
		divisionVisualisation.get(1).append("|" + quotient);
		return quotient.toString();
	}
	
	/**
	 * Calculates decimal part of the quotient.
	 */
	private void divideDecimals() {
		StringBuilder decimalResult = new StringBuilder(100);
		ArrayList<Integer> decimalRemainders = new ArrayList<Integer>(100);
		int indexStartRepeating;
		while (decimalRemainders.size() < 100) {
			decimalRemainders.add(transitionalRemainder);
			indexStartRepeating = getIndexRepeatRemainder(decimalRemainders);
			if (indexStartRepeating != -1) {
				decimalResult.insert(indexStartRepeating, "(");
				decimalResult.append(")");
				break;
			}
			transitionalDividend = transitionalRemainder * 10;
			transitionalQuotient = transitionalDividend/divisor;
			decimalResult.append(transitionalQuotient);
			transitionalProduct = transitionalQuotient * divisor;
			transitionalRemainder = transitionalDividend - transitionalProduct;
			writeDivisionCycle(transitionalDividend, transitionalProduct,
					           transitionalRemainder);
			if (transitionalRemainder == 0) {
				break;
			}
		}
		quotient.append(".");
		quotient.append(decimalResult);
	}
	
	/**
	 * Searches for the decimal reminder which repeats.
	 * 
	 * @param remainders is a list of decimal remainders
	 * @return index of repeating remainder or -1 if no repeating
	 */
	private int getIndexRepeatRemainder(ArrayList<Integer> remainders) {
		for (int i = 0; i < remainders.size()-1; i++) {
			if (remainders.get(remainders.size()
					           - 1).equals(remainders.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Writes division cycle to the visualization list.
	 * 
	 * @param minuend
	 * @param subtrahend
	 * @param difference
	 */
	private void writeDivisionCycle(int minuend,
			                              int subtrahend, int difference) {
		int minuendLength = ("" + minuend).length();
		int subtrahendLength = ("" + subtrahend).length();
		int differenceLength = ("" + difference).length();
		writeDivisionValue("" + minuend, indent);
		int additionalIndent = minuendLength - subtrahendLength;
		writeDivisionValue("-" + subtrahend, indent - 1 + additionalIndent);
		StringBuilder underline = new StringBuilder();
		for (int i = 0; i < minuendLength; i++) {
			underline.append("-");
		}
		writeDivisionValue(underline.toString(), indent);
		indent += (minuendLength - differenceLength);
		if (difference == 0) {
			indent++;
		}
	}
	
	/**
	 * Writes value to the visualization list.
	 * 
	 * @param valueWrite
	 * @param indentation
	 */
	private void writeDivisionValue(String valueWrite, int indentation) {
		divisionVisualisation.add(new StringBuilder());
		for (int i = 0; i < indentation; i++) {
			divisionVisualisation.get(divisionVisualisation.size()
					                  - 1).append(" ");
		}
		divisionVisualisation.get(divisionVisualisation.size()
				                  - 1).append(valueWrite);
	}
	
	/**
	 * Transforms visualization ArrayList to String
	 * 
	 * @return visualization String
	 * @throws LongDivisionException if visualization is absent
	 */
	public String visualize() throws LongDivisionException {
		if (divisionVisualisation.isEmpty()) {
			throw new LongDivisionException("Division is not performed yet.");
		}
		StringBuilder result = new StringBuilder(200);
		for (StringBuilder value : divisionVisualisation) {
			result.append(value);
			result.append("\n");
		}
		return result.toString();
	}
	
}
