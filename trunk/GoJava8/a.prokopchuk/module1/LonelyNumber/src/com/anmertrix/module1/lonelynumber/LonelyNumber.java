package com.anmertrix.module1.lonelynumber;

public class LonelyNumber {

	public static void main(String[] args) {
		int[] numberList = {2, 3, 2, 4, 3, 7, 9, 2, 3, 4, 4};
		
		NumberHelper number = new NumberHelper(numberList);
		System.out.print(number.getNumber());
	}

}
