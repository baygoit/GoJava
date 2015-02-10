package ua.com.goit.gojava.kickstarter;

import java.util.Scanner;

public class ConsoleIO implements IO {
	@Override
	public String read() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine(); // Я читал одно слово, а надо было всю строку
		// юнит тесты не гарантируют что все в связке будет работать, потому проверяй ручками
	}

	@Override
	public void print(String message) {
		System.out.print(message);
	}
}
