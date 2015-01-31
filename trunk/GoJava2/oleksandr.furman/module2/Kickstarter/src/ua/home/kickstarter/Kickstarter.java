package ua.home.kickstarter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Kickstarter {

	private Categories categories;
	private Projects projects;

	public Kickstarter(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("d:\\ss12.json"));

			Category category1 = new Category("Games");
			Category category2 = new Category("Technology");
			Category category3 = new Category("Design");

			Categories categories = new Categories();

			categories.add(category1);
			categories.add(category2);
			categories.add(category3);

			JSONObject jsonObject1 = (JSONObject) a.get(0);
			JSONObject jsonObject2 = (JSONObject) a.get(1);
			JSONObject jsonObject3 = (JSONObject) a.get(2);
			JSONObject jsonObject4 = (JSONObject) a.get(3);
			JSONObject jsonObject5 = (JSONObject) a.get(4);
			JSONObject jsonObject6 = (JSONObject) a.get(5);

			Project project1 = new Project("" + jsonObject1.get("name"), "" + jsonObject1.get("description"),
					Integer.parseInt("" + jsonObject1.get("goal")), Integer.parseInt("" + jsonObject1.get("daysLeft")),
					"" + jsonObject1.get("history"), "" + jsonObject1.get("linksToVideo"));
			Project project2 = new Project("" + jsonObject2.get("name"), "" + jsonObject2.get("description"),
					Integer.parseInt("" + jsonObject2.get("goal")), Integer.parseInt("" + jsonObject2.get("daysLeft")),
					"" + jsonObject2.get("history"), "" + jsonObject2.get("linksToVideo"));
			Project project3 = new Project("" + jsonObject3.get("name"), "" + jsonObject3.get("description"),
					Integer.parseInt("" + jsonObject3.get("goal")), Integer.parseInt("" + jsonObject3.get("daysLeft")),
					"" + jsonObject3.get("history"), "" + jsonObject3.get("linksToVideo"));
			Project project4 = new Project("" + jsonObject4.get("name"), "" + jsonObject4.get("description"),
					Integer.parseInt("" + jsonObject4.get("goal")), Integer.parseInt("" + jsonObject4.get("daysLeft")),

					"" + jsonObject4.get("history"), "" + jsonObject4.get("linksToVideo"));
			Project project5 = new Project("" + jsonObject5.get("name"), "" + jsonObject5.get("description"),
					Integer.parseInt("" + jsonObject5.get("goal")), Integer.parseInt("" + jsonObject5.get("daysLeft")),
					"" + jsonObject5.get("history"), "" + jsonObject5.get("linksToVideo"));
			Project project6 = new Project("" + jsonObject6.get("name"), "" + jsonObject6.get("description"),
					Integer.parseInt("" + jsonObject6.get("goal")), Integer.parseInt("" + jsonObject6.get("daysLeft")),
					"" + jsonObject6.get("history"), "" + jsonObject6.get("linksToVideo"));

			project1.setCategory(category1);
			project2.setCategory(category1);
			project3.setCategory(category1);
			project4.setCategory(category2);
			project5.setCategory(category2);
			project6.setCategory(category2);

			Projects projects = new Projects();
			projects.add(project1);
			projects.add(project2);
			projects.add(project3);
			projects.add(project4);
			projects.add(project5);
			projects.add(project6);

			Kickstarter kickstarter = new Kickstarter(categories, projects);
			kickstarter.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void run() {
		InOut inOut = new InOut();
		Quotations quotations = new Quotations();
		inOut.output(quotations.nextQuote());

		while (true) {
			try {
				inOut.output("");
				inOut.output("Выберите категорию:");
				for (Map.Entry<Integer, Category> pair : categories.getCategories().entrySet()) {
					inOut.output(pair.getKey() + " - " + pair.getValue().getName());
				}

				int categoryIndex = inOut.input();
				Category category = categories.getName(categoryIndex);
				inOut.output("Вы выбрали категорию " + category.getName());
				while (true) {
					inOut.output("");
					inOut.output("Выберите проект:");
					inOut.output("------------------------------------");
					List<Project> foundProjects = projects.getProjects(category);
					for (Project project : foundProjects) {
						inOut.output("Название проекта:           " + project.getName());
						inOut.output("Описание проекта:           " + project.getDescription());
						inOut.output("Необходимая сумма:          " + project.getGoal() + "$");
						inOut.output("Собранная сумма:            " + project.getPledged() + "$");
						inOut.output("До окончания сбора средств: " + project.getDaysLeft() + " дней");
						inOut.output("------------------------------------");
					}

					inOut.output("Введите 0 для выхода");
					inOut.output("");

					int projectIndex = inOut.input();
					if (projectIndex == 0)
						break;
					Project project = projects.getFullProject(projectIndex, category);
					inOut.output("Вы выбрали проект " + project.getName());
					inOut.output("");
					inOut.output("Название проекта:           " + project.getName());
					inOut.output("Описание проекта:           " + project.getDescription());
					inOut.output("Необходимая сумма:          " + project.getGoal() + "$");
					inOut.output("Собранная сумма:            " + project.getPledged() + "$");
					inOut.output("До окончания сбора средств: " + project.getDaysLeft() + " дней");
					inOut.output("История проекта:            " + project.getHistory());
					inOut.output("Линки на видео с демо       " + project.getLinksToVideo());
					inOut.output("Вопросы/ответы:             " + project.getQuestions());
					inOut.output("------------------------------------");
					inOut.output("Введите 0 для выхода");
					int exit = inOut.input();
				}
			} catch (IndexOutOfBoundsException e) {
				inOut.output("Введенный номер не соответствует ни одной категории(проекту), повторите ввод.");
			} catch (InputMismatchException e) {
				inOut.output("Введен некорректный символ, допустим ввод цифр от 0-9. Повторите ввод.");
			}
		}
	}
}