package com.goit.logic;

import java.util.ArrayList;
import java.util.List;

public class CardCheker {

	private static final int MAX_PART = 9999;
	private static final int MAX_CVV_CODE = 999;
	private static final int MAX_MONTH = 12;
	private static final int MAX_YEAR = 99;

	private List<Integer> partsCard = new ArrayList<Integer>();
	
	// 1234 5678 9101 1121
	public boolean chekCardNumber(String cardNumber) throws NumberFormatException { 
		setPartsCard(cardNumber);
		for (int index = 0; index < partsCard.size(); index++) {
			if (partsCard.get(index) > MAX_PART) {
				return false;
			}
		}
		return true;
	}

	public boolean chekValidTrue(String date) throws IndexOutOfBoundsException, NumberFormatException {// 05/17; month/year
		String[] montYear = date.split("/");
		if (chekCardMonth(new Integer(montYear[0])) &&
				chekCardYear(new Integer(montYear[1]))) {
			return false;
		}
		return true;
	}

	public boolean chekCardCVV(int cvv) {
		if (cvv > MAX_CVV_CODE) {
			return false;
		}
		return true;
	}

	private boolean chekCardMonth(int month) {
		if (month > MAX_MONTH) {
			return false;
		}
		return true;
	}

	private boolean chekCardYear(int year) {
		if (year > MAX_YEAR) {
			return false;
		}
		return true;
	}

	private void setPartsCard(String cardNumber) throws NumberFormatException {
		String[] partArray = cardNumber.split(" ");
		for (int index = 0; index < partArray.length; index++) {
			partsCard.add(new Integer(partArray[index]));
		}
	}
}
