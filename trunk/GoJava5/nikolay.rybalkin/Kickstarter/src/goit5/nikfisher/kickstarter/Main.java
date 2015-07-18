package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

import java.util.Arrays;

public class Main {

	private String SPACE = " ";
	private Categories categories;
	private Projects projects;
	private InputOutputConsoleInterface io;
	private QuoteGenerate generator;

	public Main(Categories categories, Projects projects, InputOutputConsoleInterface io, QuoteGenerate generator) {

		this.categories = categories;
		this.projects = projects;
		this.io = io;
		this.generator = generator;
	}

	public void run() {

//		Output output = new Output();

		io.println(generator.quoteGenerate());

		while (true){

			askCategory();

			int categoryIndex = io.consoleScan();

			if (categoryIndex == 0){
				break;
			}
			Category category = shooseCategory(categoryIndex);

			if (category == null){
				continue;
			}

			Project[] foundProjects = projects.getProgects(category);
			printProjects(foundProjects);

			projectMenu(foundProjects);
		}
		io.println("Sank!");
	}

	private void projectMenu(Project[] foundProjects) {
		while (true) {

            ascProject(foundProjects);

            int projectIndex = io.consoleScan();

            if (projectIndex == 0){
                break;
            }

            if (projectIndex <= 0 || foundProjects.length <  projectIndex){
				io.println("Not true index: " + projectIndex);
                continue;
            }

            Project project = foundProjects[projectIndex - 1];
            shooseProject(project);
            printProjectDetail(project);
        }
	}

	private void ascProject(Project[] foundProjects) {

		if (foundProjects.length == 0 ){
			io.println("Projects in this category do not have to exit, enter 0");
		}else {
			int from = 0;
			int to = foundProjects.length - 1;
			io.println("Select project: [" + from + "..." +  to  + " or 0 for exit to the projects list");
		}
	}

	private void printProjectDetail(Project project) {

		io.println("Project detail:");
		printProject(project);

		String history = project.getHistory();
		if (history != null){
			io.println(history);
		}

		String video = project.getFAQ();
		if (video != null){
			io.println(video);
		}

		String faq = project.getFAQ();
		if (faq != null){
			io.println(faq);
		}

		io.println("---------------------------------------");
	}

	private void printProjects(Project[] foundProjects) {

		for (int i = 0; i < foundProjects.length; i++) {
			Project project = foundProjects[i];
			io.print((i + 1) + ") ");
			printProject(project);
        }
	}

	private void printProject(Project project) {

		io.println("Project name: " + project.getName());
		io.println("Description: " + project.getDescription());
		io.println("Need collected: " + project.getAmount() + "$");
		io.println("Already collected: " + project.getExist() + "$");
		io.println("Days remaining: " + project.getDays());
		io.println("---------------------------------------");
		io.println(SPACE);
	}

	private void askCategory() {

		io.println(SPACE);
		io.println("Select category (or 0 to exit): ");
		io.println(Arrays.toString(categories.getCategories()));
	}

	private Category shooseCategory(int categoryIndex) {

		if ( categoryIndex <= 0 || categories.size() < categoryIndex){
			io.println("Not true index: " + categoryIndex);
			return null;
		}

		Category category = categories.get(categoryIndex - 1);
		io.println("You selected category: " + category.getName());
		return category;
	}

	private void shooseProject(Project project) {

		io.println("You selected project: " + project.getName());
	}


}

//TODO UserStory 6 Как гость я хочу инвестировать в понравившийся мне проект, чтобы поддержать его
//TODO Сценарий: Находясь в конкретном проекте -> Вижу меню с вариантами, что могу сделать, один из пунктов - проинвестировать в проект ->
//TODO Выбираю его -> Вижу вопрос от пеймент системы о вводе имени и номера карточки и суммы -> Ввожу их ->
//TODO Перехожу на описание проекта, где вижу что инфа о количестве пожертвований поменялась

