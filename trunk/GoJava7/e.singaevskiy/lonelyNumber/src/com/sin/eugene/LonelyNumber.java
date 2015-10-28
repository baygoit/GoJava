package com.sin.eugene;

public class LonelyNumber {

	public static int findLonely(int[] numbers, int targetCount) {

		int result = 0;
		for (int i = 0, sum; i < numbers.length; i++) {
			sum = 0;
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]){
					sum++;
				}
				if (sum > targetCount){
					break;
				}
			}
			if (sum == targetCount) {
				result = numbers[i];
				break;
			}
		}
		return result;

	}

}
