package ua.com.goit.gojava7.kickstarter;

import java.util.List;

public final class ConsolePrinter {

	private ConsolePrinter() {

	}

	public static void println(String string) {
		System.out.println(string);
	}

	public static void println(List<String> aCategories) {
		for (int i = 0; i < aCategories.size(); i++) {
			ConsolePrinter.println(i + " : " + aCategories.get(i));
		}
	}
}
