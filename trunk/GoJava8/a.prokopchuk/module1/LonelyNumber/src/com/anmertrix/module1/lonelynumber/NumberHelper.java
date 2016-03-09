package com.anmertrix.module1.lonelynumber;

public class NumberHelper {
	int[] numbers;
	int number;
	
	public NumberHelper(int[] numbers) {
		this.numbers = numbers;
		searchLonelyNumber();
	}
	
	public int getNumber(){
		return number;
	}
	
	protected void searchLonelyNumber(){
		int count;
		for (int i = 0; i < numbers.length; i++) {
			count = 0;
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					count++;
				}
			}
			if (count==1) {
				this.number = numbers[i];
				break;
			}
		}
	}
}
