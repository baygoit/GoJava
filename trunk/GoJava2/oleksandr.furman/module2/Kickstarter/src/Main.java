import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.menu();
	}

	private void menu() {
		Kickstarter kickstarter = new Kickstarter();
		Quotations quotation = new Quotations();
		ProjectsDescription projectsDescription = new ProjectsDescription();
		kickstarter.process();
		System.out.println(quotation.quotations());
		System.out.println();
		while (true) {
			System.out.println("Категории:");

			for (String text : kickstarter.categories) {
				System.out.println(text);
			}

			System.out.println("Для выбора категории введите ее номер.");
			Scanner scanner = new Scanner(System.in);

			int category = Integer.parseInt(scanner.nextLine());
			if (category == 0)
				break;
			while (true) {
				if (category <= kickstarter.categories.size()) {
					System.out.println("Вы выбрали категорию " + kickstarter.categories.get(category - 1));
				} else {
					System.out.println("Вы выбрали несуществующую категорию");
				}

				if (category == 1) {

					projectsDescription.projectsDescription(kickstarter.game1);
					projectsDescription.projectsDescription(kickstarter.game2);
					projectsDescription.projectsDescription(kickstarter.game3);
					System.out.println("0 - Выход");
					System.out.println("Для выбора проекта введите его номер.");

					int project = Integer.parseInt(scanner.nextLine());
					if (project == 0)
						break;
					if (project == 1) {
						projectsDescription.projectsFullDescription(kickstarter.game1);
					} else if (project == 2) {
						projectsDescription.projectsFullDescription(kickstarter.game2);
					} else if (project == 3) {
						projectsDescription.projectsFullDescription(kickstarter.game3);
					}

				} else if (category == 2) {

					projectsDescription.projectsDescription(kickstarter.technology1);
					projectsDescription.projectsDescription(kickstarter.technology2);
					projectsDescription.projectsDescription(kickstarter.technology3);
					System.out.println("Для выбора проекта введите его номер.");
					int project = Integer.parseInt(scanner.nextLine());
					if (project == 0)
						break;
					if (project == 1) {
						projectsDescription.projectsFullDescription(kickstarter.technology1);
					} else if (project == 2) {
						projectsDescription.projectsFullDescription(kickstarter.technology2);
					} else if (project == 3) {
						projectsDescription.projectsFullDescription(kickstarter.technology3);
					}
				}
				int project = Integer.parseInt(scanner.nextLine());
				if (project == 0)
					continue;
			}
		}
	}
}
