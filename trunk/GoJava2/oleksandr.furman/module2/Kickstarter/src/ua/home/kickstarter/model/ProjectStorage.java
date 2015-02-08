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

	private List<Project> project;

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
			JSONArray jsonProjects = (JSONArray) parser.parse(new FileReader("d:\\Projects.json"));
			project = new ArrayList<Project>();
			for (int i = 0; i < jsonProjects.size(); i++) {
				project.add(new Project((JSONObject) jsonProjects.get(i)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void setProjectsCategories() {
		projects = new HashMap<Category, List<Project>>();
		project.get(0).setCategory(categoryStorage.getSpecificContent(1));
		project.get(1).setCategory(categoryStorage.getSpecificContent(1));
		project.get(2).setCategory(categoryStorage.getSpecificContent(1));
		project.get(3).setCategory(categoryStorage.getSpecificContent(2));
		project.get(4).setCategory(categoryStorage.getSpecificContent(2));
		project.get(5).setCategory(categoryStorage.getSpecificContent(2));
	}

	private void putProjectsToMap() {
		for (int i = 0; i < project.size(); i++) {
			if (projects.containsKey(project.get(i).getCategory())) {
				projects.get(project.get(i).getCategory()).add(project.get(i));
			} else {
				ArrayList<Project> projectsList = new ArrayList<Project>();
				projectsList.add(project.get(i));
				projects.put(project.get(i).getCategory(), projectsList);
			}
		}
	}

	private void setProjectsHistory() {
		project.get(0).setHistory("История проекта...");
		project.get(1).setHistory("История проекта №2");
	}

	private void setProjectsQuestionAnswers() {
		project.get(0).setQuestionAnswers("Q: вопрос? А: ответ! 1 ");
		project.get(1).setQuestionAnswers("Q: вопрос? А: ответ! 2");
	}

	public Map<Category, List<Project>> getContent() {
		return projects;
	}

	public List<Project> getSpecificContent(Category category) {
		return projects.get(category);
	}
}