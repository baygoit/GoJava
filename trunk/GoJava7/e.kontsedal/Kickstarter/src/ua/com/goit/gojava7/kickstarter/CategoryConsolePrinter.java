package ua.com.goit.gojava7.kickstarter;

public final class CategoryConsolePrinter extends ConsolePrinter {
	private CategoryConsolePrinter() {

	}

	public static void println(Category category) {
		System.out.println(category.getName() + "\n=======");

		for (Project project : category.getAllProjectsInCategory()) {
			System.out.println(
					"========================\n" + project.getProjectName()
							+ "\n" + project.getProjectShortDescription() + "\n"
							+ project.getProjectCostNeed() + "\n"
							+ project.getProjectCostCollected() + "\n"
							+ project.getProjectDaysLeft() + "\n"
							+ "========================");
		}
	}
}
