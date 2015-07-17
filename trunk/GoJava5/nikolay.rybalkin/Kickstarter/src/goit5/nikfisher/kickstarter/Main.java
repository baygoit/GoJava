package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.Output;
import goit5.nikfisher.kickstarter.streams.Read;
import goit5.nikfisher.kickstarter.streams.ScanConsole;

import java.util.Arrays;
import java.util.Random;

public class Main {

	private String SPACE = " ";
	private Categories categories;
	private Projects projects;
	private Output output = new Output();
	private Read read;

	public Main(Categories categories, Projects projects, Read read) {

		this.categories = categories;
		this.projects = projects;
		this.read = read;
	}

	public void run() {

		Output output = new Output();

		QuoteGenerate generate = new QuoteGenerate(new Random());
		output.println(generate.quoteGenerate());

		while (true){

			askCategory();

			int categoryIndex = read.consoleScan();

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
	}

	private void projectMenu(Project[] foundProjects) {
		while (true) {

            ascProject(foundProjects);

            int projectIndex = read.consoleScan();

            if (projectIndex == 0){
                break;
            }

            if (projectIndex <= 0 || foundProjects.length <  projectIndex){
                output.println("Not true index: " + projectIndex);
                continue;
            }

            Project project = foundProjects[projectIndex - 1];
            shooseProject(project);
            printProjectDetail(project);
        }
	}

	private void ascProject(Project[] foundProjects) {

		if (foundProjects.length == 0 ){
			output.println("Projects in this category do not have to exit, enter 0");
		}else {
			int from = 0;
			int to = foundProjects.length - 1;
			output.println("Select project: [" + from + "..." +  to  + " or 0 for exit to the projects list");
		}
	}

	private void printProjectDetail(Project project) {

		output.println("goit5.nikfisher.kickstarter.model.Project detail:");
		printProject(project);

		String history = project.getHistory();
		if (history != null){
			output.println(history);
		}

		String video = project.getFAQ();
		if (video != null){
			output.println(video);
		}

		String faq = project.getFAQ();
		if (faq != null){
			output.println(faq);
		}

		output.println("---------------------------------------");
	}

	private void printProjects(Project[] foundProjects) {

		for (int i = 0; i < foundProjects.length; i++) {
			Project project = foundProjects[i];
			output.print((i + 1) + ") ");
			printProject(project);
        }
	}

	private void printProject(Project project) {

		output.println("goit5.nikfisher.kickstarter.model.Project name: " + project.getName());
		output.println("Description: " + project.getDescription());
		output.println("Need collected: " + project.getAmount() + "$");
		output.println("Already collected: " + project.getExist() + "$");
		output.println("Days remaining: " + project.getDays());
		output.println("---------------------------------------");
		output.println(SPACE);
	}

	private void askCategory() {

		output.println(SPACE);
		output.println("Select category (or 0 to exit): ");
		output.println(Arrays.toString(categories.getCategories()));
	}

	private Category shooseCategory(int categoryIndex) {

		if ( categoryIndex <= 0 || categories.size() < categoryIndex){
			output.println("Not true index: " + categoryIndex);
			return null;
		}

		Category category = categories.get(categoryIndex - 1);
		output.println("You selected category: " + category.getName());
		return category;
	}

	private void shooseProject(Project project) {

		output.println("You selected project: " + project.getName());
	}

}

