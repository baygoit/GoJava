package kickstarter_gk;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;

import sun.invoke.empty.Empty;

public class Controler {

	int position;
	int level;

	private Model model;
	private View view;
	private Scaner scan;
	private Menu menu;

	ArrayList<Project> projectInCategory;
	Project p;
	int currentCategory = 0;
	Project projectSelected;

	public Controler(Model model, View view, Scaner scan, Menu menu) {
		this.model = model;
		this.view = view;
		this.scan = scan;
		this.menu = menu;
	}

	public void start() {
		// Инициализируем списки объектов
		model.initCategory();
		model.initProjects();
		model.initFAQs();
		model.initPaymentVar();
		// Показываем цитату
		view.showCitation();

		ArrayList<Project> projectsList = model.ProjectList();
		ArrayList<Category> categoriesList = model.CategoryList();

		// Меню

		int levelMenu = 1;
		int position = 0;

		boolean exitFromApplication = false;
		while (!exitFromApplication) {

			do {

				// Показал уровень меню
				levelMenu = LevelMenu(levelMenu, position);
				view.showThis("---------------------");

				view.showSelect();

				// Спросил
				position = scan.Input();
				view.showThis(position + "1 " + levelMenu);

			} while (position != 0); // Если не ноль - повторяем, показываем +
										// действие + переходим вниз на уровень.
			levelMenu = levelMenu - 1; // Если ноль - уменьшаем уровень меню.

			if (levelMenu < 0) {
				exitFromApplication = true;
				System.out.println("Thanks for using!");

			} // Если все еще не нулевой, возвращаемся к показу предыдущего
				// уровня меню.

		}

		scan.finalize();
	}

	public int LevelMenu(int level, int position) {
		this.level = level;
		this.position = position;

		ArrayList<Category> categoriesList = model.CategoryList();
		// Показать уровень категорий. Верхний уровень.
		if (level == 1 && position == 0) {
			int counter = 1;
			for (Object category : categoriesList) {
				view.showThis("(" + counter + ") " + category);
				counter++;
			}
			level = 1;
			return level;
		}

		// Переход на уровень проектов сверху. Показываем проекты в заданной
		// категории.
		if (level == 1 && position != 0) {

			view.showThis("Projects in Category: "
					+ categoriesList.get(position - 1).NameCategory);
			projectInCategory = model.getProjectInCategory(categoriesList
					.get(position - 1));
			currentCategory = position - 1;
			if (projectInCategory.isEmpty()) {
				view.showThis("No project in Category");
				level = 2;
				return level;
			} else {
				int i = 1;
				for (Project p : projectInCategory) {
					view.showThis("(" + i + ")" + p.outLong());
					i++;

				}

				level = 2;
				return level;
			}
		}

		// Уровень проекта. Показываем данные конкретного проекта.
		if (level == 2 && position != 0) {

			projectSelected = projectInCategory.get(position - 1);

			view.showProject(projectSelected);
			view.showThis("(1) - Invest into project");
			view.showThis("(2) - Ask us about");
			view.showThis(level + "-" + position);

			level = 3;
			position = 0;
		}

		if (level == 3 && position == 1) {

			investIntoProject(projectSelected);

		}

		if (level == 3 && position == 2) {

			askQuestionAboutProject(projectSelected);

		}
		return level;
	}

	private void askQuestionAboutProject(Project project) {
		ArrayList<FAQ> FAQin = model.getFaqInProject(project);
		view.showThis("Project: " + project.getName() + " FAQs:");
		for (FAQ faq : FAQin) {
			view.showThis("Question: " + faq.getQuestion());
			view.showThis("Answer: " + faq.getAnswer());
		}

		view.showThis("Please, ask us about project: ");

		String quest = scan.InputString();

		view.showThis(quest + " - what's a wonderful question!");

		view.showThis("Thanks!");
		model.addNewFAQ(project, quest);

	}

	private void investIntoProject(Project project) {
		int select;
		
		this.projectSelected = project;
		view.showThis("Project: " + projectSelected.getName() + " need "
				+ projectSelected.getTotal() + "$ to start");

		view.showThis("Now collected: "
				+ projectSelected.getDonated()
				+ " only. ");

		// Вывод списков
		
		ArrayList<PaymentVar> PaymentVar = model
				.getPaymentVarInProject(project);

		if (!PaymentVar.isEmpty()){
			
		for (int i = 1; i < PaymentVar.size() + 1; i++) {

			view.showThis("(" + i + "): " + PaymentVar.get(i - 1).getSumm()
					+ " " + PaymentVar.get(i - 1).getDesc());
			view.showThis("");
		}

        view.showThis("Please, enter number to select donation or 0 to enter your summ: ");
		
		select = scan.Input();
		}	else { 
			select = 0;
		}
	
		
		view.showThis("Please, enter:");
		
		view.showThis("Your name: ");
		String name = scan.InputString();
		view.showThis("Thanks, " + name + "! Enter your card number:");

		float card = scan.InputFloat();
		
		float donation;
		if (select == 0) { 
		view.showThis("Enter your donation:");
		 donation = scan.InputFloat();
		} else {
			donation = PaymentVar.get(select-1).getSumm();
		}
		
		projectSelected.setDonated(donation);

		view.showThis("Your donation extremely important for us!");
		view.showThis("Now we collected: " + projectSelected.getDonated()
				+ "$!");
	}

}
