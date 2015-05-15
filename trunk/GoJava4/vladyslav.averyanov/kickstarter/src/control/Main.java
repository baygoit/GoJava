package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

import model.Category;
import model.Project;
import model.Quote;
import control.QuoteService;
import view.ConsolePrinter;

public class Main {

	public static int DEFAULT_VALUE = -1;

	public static void main(String[] args) {
		Quote[] quoteSet = {
				new Quote(
						"«Пишите код так, как будто сопровождать его будет склонный к насилию психопат, "
								+ "который знает, где вы живете.»",
						"Стив Макконнелл"),
				new Quote("«Если что-то работает — то не трогай это»",
						"Неизвестный автор"),
				new Quote(
						"«Самый лучший способ изучать язык программирования — это писать на нем программы»",
						"Неизвестный автор"),
				new Quote(
						"«Хороший программист — это тот, кто смотрит в обе стороны, переходя дорогу с односторонним движением»",
						"Даг Линдер"),
				new Quote(
						"«Сложность программы растет до тех пор, пока не превысит способности программиста»",
						"Законы Мэрфи") };

		Category videoCategory = new Category("Video",
				"Any video you can imagine. Start from multibillionaire "
						+ "blockbasters and ending your home videos");
		Category audioCategory = new Category("Audio",
				"Any audio you can imagine. New DJ-set or special musical "
						+ "instrument - all of it here");

		String[] questionsAndAnswers = { "Question 1; -> Answer 1;",
				"Question 2; -> Answer 2;", "Question 3; -> Answer 3;" };

		Project firstVideoProject = new Project("First Video Project",
				"it is short description of it", 15000, 3698, 100,
				videoCategory, "history of the project", questionsAndAnswers);
		Project secondVideoProject = new Project("Second Video Project",
				"it is short description of it", 320000, 12020, 200,
				videoCategory, "history of the project", questionsAndAnswers);
		Project thirdVideoProject = new Project("Third Video Project",
				"it is short description of it", 64000, 20, 300, videoCategory,
				"history of the project", questionsAndAnswers);
		Project fourthVideoProject = new Project("4th Video Project",
				"it is short description of it", 128000, 10, 400,
				videoCategory, "history of the project", questionsAndAnswers);
		Project[] videoProjects = { firstVideoProject, secondVideoProject,
				thirdVideoProject, fourthVideoProject };

		Project firstAudioProject = new Project("First Audio Project",
				"it is short description of the Audio Project", 1000, 10999,
				100, audioCategory, "history of the project",
				questionsAndAnswers);
		Project secondAudioProject = new Project("Second Audio Project",
				"it is short description of the Audio Project", 2000, 2999,
				200, audioCategory, "history of the project",
				questionsAndAnswers);
		Project thirdAudioProject = new Project("Third Audio Project",
				"it is short description of the Audio Project", 3000, 3999,
				300, audioCategory, "history of the project",
				questionsAndAnswers);
		Project[] audioProjects = { firstAudioProject, secondAudioProject,
				thirdAudioProject };

		videoCategory.setProjects(videoProjects);
		audioCategory.setProjects(audioProjects);
		Category[] categoryArray = { videoCategory, audioCategory };

		boolean isExit = false;
		while (!isExit) {
			Quote chosenQuote = quoteSet[new Random().nextInt(quoteSet.length)];
			System.out.println(chosenQuote.getQuoteWithAuthor());
			showCategories(categoryArray);
			System.out.print("Please choose category or print 0 to exit: ");

			int userInput = DEFAULT_VALUE;
			userInput = readUserInput();
			if (userInput == 0) {
				isExit = true;
			} else if (userInput > 0 && userInput <= categoryArray.length) {
				showCategoryMenu(categoryArray[userInput-1]);
			} else {
				System.out.println("No such category.");
			}
		}
	}

	public static int readUserInput() {
		int result = DEFAULT_VALUE;
		try {
			result = new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return (result >= DEFAULT_VALUE) ? result : DEFAULT_VALUE;
	}

	public static void showCategories(Category[] categories) {
		System.out.println("Select category: ");
		for (int i = 0; i < categories.length; i++) {
			System.out.println(i + 1 + ": " + categories[i].getName());
		}
	}

	public static void showCategoryMenu(Category category) {

		Project[] projectsOfCurrentCategory = category.getProjects();

		while (true) {

			showProjectsOfCategory(category);

			System.out.println();
			System.out.println("Press 0 for exit from this category");
			System.out.println("--------------------------------------------");

			int keyCode = readUserInput();
			if (keyCode == 0) {
				break;
			} else {
				if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.length) {
					Project selectedProject = projectsOfCurrentCategory[keyCode - 1];
					showProjectMenu(selectedProject);
				} else {
					System.out.println("Project with №" + keyCode
							+ " does not exist");
				}
			}
		}
	}

	public static void showProjectsOfCategory(Category category) {
		System.out.println("Category: " + category.getName());
		System.out.println("  Projects: ");
		Project[] currentCategoryProjects = category.getProjects();
		for (int i = 0; i < currentCategoryProjects.length; i++) {
			System.out.print("  " + (i + 1) + ": ");
			System.out.println(currentCategoryProjects[i].getName());
			System.out.println(" Short Description: "
					+ currentCategoryProjects[i].getShortDescription());
			System.out.println(" Needed amount: "
					+ currentCategoryProjects[i].getNeededAmount());
			System.out.println(" Current money: "
					+ currentCategoryProjects[i].getCurrentAmount());
			System.out.println(" Days left: "
					+ currentCategoryProjects[i].getDaysLeft());
		}
	}

	public static void showProjectInfo(Project project) {
        System.out.println(project.getName());
        System.out.println(" Short Description: " + project.getShortDescription());
        System.out.println(" Needed amount: " + project.getNeededAmount());
        System.out.println(" Current money: " + project.getCurrentAmount());
        System.out.println(" Days left: " + project.getDaysLeft());
        System.out.println(" History: " + project.getHistory());
        //System.out.println(" Video URL: " + project.getUrlVideo());
        System.out.println(" Questions And Answers: ");
        for (String s : project.getQuestionsAndAnswers()) {
            System.out.println("  " + s);
        }
    }

	public static void showProjectMenu(Project project) {
		while (true) {

			showProjectInfo(project);

			System.out.println();
			System.out.println("Press 0 to return back");
			System.out.println("--------------------------------------------");

			int keyCode = readUserInput();
			if (keyCode == 0) {
				break;
			} else {
				System.out.println("Wrong code!");
			}
		}
	}

}
