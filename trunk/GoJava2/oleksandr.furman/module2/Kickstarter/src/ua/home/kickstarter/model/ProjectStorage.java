package ua.home.kickstarter.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:\\Projects.json"));
			JsonParser parser = new JsonParser();
			JsonArray jArrayProjects = parser.parse(br).getAsJsonArray();
			Gson gson = new Gson();
			projectList = new ArrayList<Project>();
			for (JsonElement obj : jArrayProjects) {
				Project project = gson.fromJson(obj, Project.class);
				projectList.add(project);
			}
		} catch (FileNotFoundException e) {
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