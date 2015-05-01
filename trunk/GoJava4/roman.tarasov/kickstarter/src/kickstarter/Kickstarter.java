package kickstarter;

import java.util.ArrayList;
import java.util.Scanner;

public class Kickstarter {
	ArrayList<Category> listCategories;
	ArrayList<Project> listProjects;
	ArrayList<Citation> listCitations;
	ArrayList<User> listUsers;
	User user=null;
	Category category=null;
	int userId = 0;
	int projectId = 0;
	int categoryId = 0;
	int citationId = 0;
	Scanner scanner; 
	public void start(ArrayList<Category> listCategories,
			ArrayList<Project> listProjects, ArrayList<Citation> listCitations,
			ArrayList<User> listUsers) {
		this.listCategories = listCategories;
		this.listProjects = listProjects;
		this.listCitations = listCitations;
		this.listUsers = listUsers;
		scanner= new Scanner(System.in);
		newUser();
		consoleCycle();
	}

	void consoleCycle() {
		String fromConsole;
		int parsed = 0;
		while (true) {
			fromConsole = scanner.nextLine();
			try {
				parsed = Integer.parseInt(fromConsole);
				category = listCategories.get(parsed);
				
			
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.err.println("wrong number");
				continue;
			}
			
			System.out.println(category.name);
		}
	}

	void newUser() {

		boolean userIdentificated = false;
		String fromConsole;
		System.out.println("get User ID");
		do {
			try {
				fromConsole = scanner.nextLine();
				userId = Integer.parseInt(fromConsole);
				user = listUsers.get(userId);
				userIdentificated=true;
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.err.println("wrong User ID");
				continue;
			}
		} while (!userIdentificated);
		System.out.println("User Name: "+user.getName());
		System.out.println("      ID : "+userId);

	}


}
