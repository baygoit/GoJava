package ua.com.goit.gojava7.kickstarter;

public final class CategoryListConsolePrinter extends ConsolePrinter {

	private CategoryListConsolePrinter() {

	}

	public static void println(CategoryStorage categoryStorage) {
		for (int i = 0; i < categoryStorage.getAllCategories().size(); i++) {
			System.out.println(
					i + " : " + categoryStorage.getCategory(i).getName());
		}
	}

}
