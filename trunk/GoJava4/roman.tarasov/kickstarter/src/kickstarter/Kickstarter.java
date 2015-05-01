package kickstarter;

import java.util.ArrayList;
import java.util.Scanner;

public class Kickstarter {

	Repository repository;
	Citation citations;
	User users;
	Category categories;
	Project projects;

	int userId = 0;
	int projectId = 0;
	int categoryId = 0;
	int citationId = 0;
	Scanner scanner;

	public void start(Category categories, Project projects,
			Citation citations, User users) {
		this.categories = categories;
		this.projects = projects;
		this.citations = citations;
		this.users = users;
		scanner = new Scanner(System.in);
		newUser();
		consoleCycle();
	}

	void consoleCycle() {
		String fromConsole;
		String category;
		int parsed = 0;
		while (true) {
			fromConsole = scanner.nextLine();
			try {
				parsed = Integer.parseInt(fromConsole);
				category = categories.category[parsed];

			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.err.println("wrong number");
				continue;
			}

			System.out.println(category);
		}
	}

	void newUser() {

		boolean userIdentificated = false;
		String fromConsole;
		String user;
		System.out.println("get User ID");
		do {
			try {
				fromConsole = scanner.nextLine();
				userId = Integer.parseInt(fromConsole);
				 //user = users.user(userId);
				userIdentificated = true;
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.err.println("wrong User ID");
				continue;
			}
		} while (!userIdentificated);
		// System.out.println("User Name: "+user.getName());
		// System.out.println("      ID : "+userId);

	}

}
