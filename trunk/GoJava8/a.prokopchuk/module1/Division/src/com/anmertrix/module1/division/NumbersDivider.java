package com.anmertrix.module1.division;

import java.util.LinkedList;
import java.util.List;

public class NumbersDivider {
	
	private static final int RESULT_ACCURACY = 11;
	private static final String VERTICAL_SEPARATOR = "|";
	private static final String HORIZONTAL_SEPARATOR = "---";
	private int divident = 0;
	private int divider = 0;
	
	public NumbersDivider(int divident, int divider) {
		this.divident = divident;
		this.divider = divider;
	} 
	
	public void printDivision() {

		StringBuilder wholeProcessDivision = new StringBuilder();
		StringBuilder indent = new StringBuilder();
		StringBuilder wholeNumber = new StringBuilder();
		StringBuilder firstCurrentMinus = new StringBuilder();
		StringBuilder fractionNumber = new StringBuilder();
		List<Integer> remains = new LinkedList<Integer>();
		StringBuilder processDivision = new StringBuilder();
		
		appendWholeProcessDivision(wholeProcessDivision);
		setAbsoluteValue(wholeNumber);
				
		for (int i = 0; i <= RESULT_ACCURACY; i++) {
			int result = divident / divider;
			int remainder = divident % divider;
			int currentMinus = divider * result;
			if (i == 0) {
				firstCurrentMinus.append("  -").append(currentMinus);
				processDivision.append(indent).append(" ").append(HORIZONTAL_SEPARATOR).append("\n");
			} else {
				processDivision.append(indent).append(" ").append(divident).append("\n");
				processDivision.append(indent).append("-").append(currentMinus).append("\n");
				processDivision.append(indent).append(" ").append(HORIZONTAL_SEPARATOR).append("\n");
			}
			indent.append(" ");

			if (i == 0) {
				wholeNumber.append(result);
			} else {
				fractionNumber.append(result);
			}

			if (remainder == 0) {
				break;
			} else if (remains.contains(remainder)) {
				fractionNumber.insert(remains.indexOf(remainder), "(");
				fractionNumber.append(")");
				processDivision.append(indent).append(" ").append(remainder).append("\n");
				break;
			}

			divident = remainder * 10;
			remains.add(remainder);
		}

		if (fractionNumber.length() > 0) {
			fractionNumber.insert(0, ".");
		}

		wholeProcessDivision.append(firstCurrentMinus).append("|")
				.append(wholeNumber).append(fractionNumber).append("\n").append(processDivision);
		System.out.println(wholeProcessDivision);

	}
	
	private void setAbsoluteValue(StringBuilder wholeNumber) {
		if (divident < 0 ^ divider < 0) {
			wholeNumber.append("-");
		}
		if (divident < 0 || divider < 0) {
			divident = Math.abs(divident);
			divider = Math.abs(divider);
		}
		
	}
	
	private void appendWholeProcessDivision(StringBuilder wholeProcessDivision){
		if (divident > 0) {
			wholeProcessDivision.append("  " + divident + " "
					+ VERTICAL_SEPARATOR + divider + "\n");
		} else {
			wholeProcessDivision.append(" " + divident + " "
					+ VERTICAL_SEPARATOR + divider + "\n");
		}
		
	}
}
