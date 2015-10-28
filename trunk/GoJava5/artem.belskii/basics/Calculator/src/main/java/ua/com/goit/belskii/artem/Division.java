package ua.com.goit.belskii.artem;

import java.util.ArrayList;

public class Division {
	String divident, divisor;
	int divisorInt, dividentPartEndPos;
	private int remainder;
	private int dividentPart;
	ArrayList divisionProcess = new ArrayList();
	ArrayList divisionResult = new ArrayList();
	int dividentPartStartPos = 0;
	int factorialCount = 0;
	int result = Integer.MAX_VALUE;

	Division(String[] expression) {
		divident = expression[0];
		divisor = expression[1];
		divisorInt = Integer.parseInt(divisor);
		dividentPartEndPos = divisor.length();
	}
	
	public void calculate() {
		while (result > 0) {
			this.getPartDivident();
			this.partDivision();
		}
		this.getResult();
	}

	private void getPartDivident() {

		if (dividentPartStartPos == 0) {
			dividentPart = Integer.parseInt(divident.substring(
					dividentPartStartPos, dividentPartEndPos));
		}
		if (dividentPart < divisorInt && dividentPartStartPos == 0
				&& dividentPartStartPos < divisor.length()) {
			dividentPartEndPos++;
			dividentPart = Integer.parseInt(divident.substring(
					dividentPartStartPos, dividentPartEndPos));
		} else if (dividentPartStartPos > 0
				&& dividentPartStartPos < divident.length()) {
			dividentPart = Integer.parseInt(Integer.toString(remainder)
					+ divident.substring(dividentPartStartPos,
							dividentPartEndPos));
		} else if (dividentPartStartPos > divisor.length()) {
			if (factorialCount == 0) {
				divisionResult.add(".");
				dividentPart = remainder * 10;
				factorialCount++;
			}
			if (factorialCount > 0 && factorialCount <= 120) {
				dividentPart = remainder * 10;
				factorialCount++;
			}
		}
		dividentPartStartPos = dividentPartEndPos;
		dividentPartEndPos++;
	}

	private void partDivision() {
		remainder = dividentPart % divisorInt;
		result = dividentPart / divisorInt;
		divisionResult.add(result);
		divisionProcess.add("   " + dividentPart);
		divisionProcess.add("-");
		divisionProcess.add("   " + result * divisorInt);
		divisionProcess.add("______________________");
	}

	private String getResult() {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < divisionProcess.size(); i++) {
			System.out.println(divisionProcess.get(i));
		}
		for (int i = 0; i < divisionResult.size(); i++) {
			System.out.print(divisionResult.get(i));
		}
		return result.toString();
	}
}
