package com.anmertrix.module1.lonelynumber;

public class LonelyNumber {

	public static void main(String[] args) {
		int[] numberList = {2, 3, 2, 4, 3, 7, 9, 2, 3, 4, 4};
		int count;
		for (int i = 0; i < numberList.length; i++) {
			count = 0;
			for (int j = 0; j < numberList.length; j++) {
				if (numberList[i] == numberList[j]) {
					count++;
				}
			}
			if (count==1) {
				System.out.println(numberList[i]);
				break;
			}
		}
	}

}
