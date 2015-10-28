package bekskii.artem.basic;

import java.util.Scanner;

public class Input {
	Scanner consoleIn = new Scanner(System.in);
	private String input = "";

	public void setString() {
		System.out.println("Please, enter text in format 1, 1, 2, 1, 3, 3, 3");
		input = consoleIn.nextLine();
	}

	public int[] getInput() {
		String[] separateNumbers = input.split(", ");
		int[] answer = new int[separateNumbers.length];
		for (int i = 0; i < separateNumbers.length; i++) {
			answer[i] = Integer.parseInt(separateNumbers[i]);
		}
		return answer;
	}

}
