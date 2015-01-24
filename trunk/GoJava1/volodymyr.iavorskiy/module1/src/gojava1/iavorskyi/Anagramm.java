package gojava1.iavorskyi;

import java.util.Scanner;

public class Anagramm {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		String inputString = null;
		
		System.out.println("Enter string you want to reverse: ");
		inputString = in.nextLine();
		String[] separatedInputString = inputString.split(" ");
		
		for (int i = 0; i < separatedInputString.length; i++) {
			inputString = separatedInputString[i];
			inputString = sb.append(inputString).reverse().toString();
			System.out.print(inputString + " ");
			sb.setLength(0);
		}
		
		in.close();
	}
}
