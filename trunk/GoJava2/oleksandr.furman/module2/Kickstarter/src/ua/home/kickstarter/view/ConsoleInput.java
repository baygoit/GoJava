package ua.home.kickstarter.view;

import java.util.Scanner;

public class ConsoleInput {
	Scanner scanner = new Scanner(System.in);

	public int nextIntIndex() {
		boolean inputMismatch = true;
		int index = -1;
		while (inputMismatch) {
			if (scanner.hasNextInt())
				index = scanner.nextInt();
			else {
				System.out.print("Введен некорректный символ, допустим ввод цифр от 0-9. Повторите ввод.\n");
				scanner.next();
				continue;
			}
			inputMismatch = false;
		}
		return index;
	}

	public String nextString() {

		return scanner.next();
	}
}
