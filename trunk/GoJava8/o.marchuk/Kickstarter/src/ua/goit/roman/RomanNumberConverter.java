package ua.goit.roman;

import java.util.ArrayList;
import java.util.List;

public class RomanNumberConverter {

	private static final List<RomanDigit> ROMAN_DIGITS = new ArrayList<>();

	static {
		ROMAN_DIGITS.add(new RomanDigit(1000, "M"));
		ROMAN_DIGITS.add(new RomanDigit(500, "D"));
		ROMAN_DIGITS.add(new RomanDigit(100, "C"));
		ROMAN_DIGITS.add(new RomanDigit(50, "L"));
		ROMAN_DIGITS.add(new RomanDigit(10, "X"));
		ROMAN_DIGITS.add(new RomanDigit(5, "V"));
		ROMAN_DIGITS.add(new RomanDigit(1, "I"));
	}


	public String convert(final int number) {
		StringBuilder sb = new StringBuilder();

		int reducedNumber = number;
		while (reducedNumber >= 1) {
			reducedNumber = doStep(reducedNumber, sb);
		}
		return sb.toString();
	}

	private int doStep(int reducedNumber, StringBuilder sb) {
		for (RomanDigit romanDigit : ROMAN_DIGITS) {
			if (reducedNumber >= romanDigit.getArabic() && romanDigit.canBeMinused()) {
				reducedNumber -= romanDigit.getArabic();
				sb.append(romanDigit.getRoman());
			}
		}
		return reducedNumber;
	}

}
