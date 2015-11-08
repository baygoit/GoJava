package ua.com.goit.gojava7.kickstarter;

import java.util.List;

public final class ConsolePrinter {

	private ConsolePrinter() {

	}

	public static void println(String string) {
		System.out.println(string);
	}

	public static void println(List<String> aCategories) {
		for (int i = 1; i <= aCategories.size(); i++) {
			ConsolePrinter.println(i + " : " + aCategories.get(i - 1));
		}
	}

	public static void printProjects(Project aProject) {
		System.out.println("Project: " + aProject.getProjectName()
				+ " Description: " + aProject.getProjectDescription());
		System.out.println(" Aim sum:" + aProject.getProjectAimBalance()
				+ " Current balance: " + aProject.getProjectCurrentBalance()
				+ " Days till the end of project left: "
				+ aProject.getdaysLeft());
		System.out.println();

	}
}
