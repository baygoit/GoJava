package ua.com.goit.gojava7.kickstarter;

public final class ProjectsConsolePrinter extends ConsolePrinter {
	private ProjectsConsolePrinter() {

	}

	public static void println(ProjectStorage projects, int numberOfCategory) {

		for (Project project : projects
				.getAllProjectsInCategory(numberOfCategory)) {
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
