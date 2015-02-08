package ua.home.kickstarter.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.factory.StorageFactory;

public class ProjectStorage {

	private List<Project> projectList;

	private Map<Category, List<Project>> projects;
	CategoryStorage categoryStorage = new StorageFactory().getCategoryStorage();

	public ProjectStorage() {
		jsonProjectsToList();
		setProjectsCategories();
		putProjectsToMap();
		setProjectsHistory();
		setProjectsQuestionAnswers();
	}

	private void jsonProjectsToList() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonProjectsArray = (JSONArray) parser.parse(new FileReader("d:\\Projects.json"));
			projectList = new ArrayList<Project>();

			for (Object jsonProjectsObject : jsonProjectsArray) {
				JSONObject jsonProjects = (JSONObject) jsonProjectsObject;
				projectList.add(new Project("" + jsonProjects.get("name"), "" + jsonProjects.get("description"),
						Integer.parseInt("" + jsonProjects.get("goal")), Integer.parseInt(""
								+ jsonProjects.get("daysLeft")), "" + jsonProjects.get("linksToVideo")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void setProjectsCategories() {
		projects = new HashMap<Category, List<Project>>();
		projectList.get(0).setCategory(categoryStorage.getSpecificContent(1));
		projectList.get(1).setCategory(categoryStorage.getSpecificContent(1));
		projectList.get(2).setCategory(categoryStorage.getSpecificContent(1));
		projectList.get(3).setCategory(categoryStorage.getSpecificContent(2));
		projectList.get(4).setCategory(categoryStorage.getSpecificContent(2));
		projectList.get(5).setCategory(categoryStorage.getSpecificContent(2));
	}

	private void putProjectsToMap() {
		for (int i = 0; i < projectList.size(); i++) {
			if (projects.containsKey(projectList.get(i).getCategory())) {
				projects.get(projectList.get(i).getCategory()).add(projectList.get(i));
			} else {
				ArrayList<Project> projectsList = new ArrayList<Project>();
				projectsList.add(projectList.get(i));
				projects.put(projectList.get(i).getCategory(), projectsList);
			}
		}
	}

	private void setProjectsHistory() {
		projectList.get(0).setHistory("История проекта...");
		projectList.get(1).setHistory("История проекта №2");
	}

	private void setProjectsQuestionAnswers() {
		projectList.get(0).setQuestionAnswers("Q: вопрос? А: ответ! 1 ");
		projectList.get(1).setQuestionAnswers("Q: вопрос? А: ответ! 2");
	}

	public Map<Category, List<Project>> getContent() {
		return projects;
	}

	public List<Project> getSpecificContent(Category category) {
		return projects.get(category);
	}
}