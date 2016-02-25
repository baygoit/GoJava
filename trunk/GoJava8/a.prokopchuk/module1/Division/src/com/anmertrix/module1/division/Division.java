package com.anmertrix.module1.division;

public class Division {

	public static void main(String[] args) {
		Reader reader = new Reader();
		String line = reader.readUserNumbers();
		
		String[] lineParts = line.split("/");
		
		int[] numberList = new int[2];
		for (int i = 0; i < lineParts.length; i++) {
			try {
				numberList[i] = Integer.parseInt(lineParts[i]);
			} catch (Exception e) {
				System.out.println("You can enter only numbers.");
				return;
			}
		}
		int divident = numberList[0];
		int divider = numberList[1];
		
		NumbersDivider numberDivider = new NumbersDivider(divident, divider);
		
		numberDivider.printDivision();

	}

	

}
