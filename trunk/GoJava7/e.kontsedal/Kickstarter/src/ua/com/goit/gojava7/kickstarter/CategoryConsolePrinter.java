package ua.com.goit.gojava7.kickstarter;

public final class CategoryConsolePrinter extends ConsolePrinter {
	private CategoryConsolePrinter() {

	}

	public static void println(Category category) {
		System.out.println("=======\n" + category.getName() + "\n=======");

	}
}
