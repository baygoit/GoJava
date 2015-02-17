package ua.home.kickstarter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import utils.KickstarterJsonReader;
import utils.KickstarterJsonWriter;

public class ProjectStorage {

	private List<Project> projectList;
	private Map<Category, List<Project>> sortedByCategoryProjects;

	public ProjectStorage() {
		init();
	}

	private void init() {
		jsonProjectsToList();
		sortedByCategoryProjects = putProjectsToMap(projectList);
		setProjectsHistory();
		setProjectsQuestionAnswers();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void jsonProjectsToList() {
		KickstarterJsonReader jsonReader = new KickstarterJsonReader();
		projectList = jsonReader.getList(Project.class, "Projects.json");
	}

	public void saveJsonToHardDrive() {
		KickstarterJsonWriter kickstarterJsonWriter = new KickstarterJsonWriter();
		kickstarterJsonWriter.saveJsonToHardDrive(projectList, "Projects.json");
	}

	public Map<Category, List<Project>> putProjectsToMap(List<Project> projectList) {
		Map<Category, List<Project>> projects = new HashMap<Category, List<Project>>();
		for (int i = 0; i < projectList.size(); i++) {
			if (projects.containsKey(projectList.get(i).getCategory())) {
				projects.get(projectList.get(i).getCategory()).add(projectList.get(i));
			} else {
				ArrayList<Project> projectsList = new ArrayList<Project>();
				projectsList.add(projectList.get(i));
				projects.put(projectList.get(i).getCategory(), projectsList);
			}
		}
		return projects;
	}

	public void setProjectsHistory() {
		projectList.get(0).setHistory("История проекта...");
		projectList.get(1).setHistory("История проекта №2");
	}

	public void setProjectsQuestionAnswers() {
		projectList.get(0).setQuestionAnswers("Q: вопрос? А: ответ! 1 ");
		projectList.get(1).setQuestionAnswers("Q: вопрос? А: ответ! 2");
	}

	public Map<Category, List<Project>> getContent() {
		return sortedByCategoryProjects;
	}

	public String getSpecificContent(Category category) {
		int projectNumber = 1;
		StringBuilder projectsContent = new StringBuilder();
		for (Project project : sortedByCategoryProjects.get(category)) {
			projectsContent.append(projectNumber).append(project.getShortInfo()).append("\n");
			projectNumber++;
		}
		return projectsContent.toString();
	}

	public String getSpecificProjects(int index, Category category) {
		return sortedByCategoryProjects.get(category).get(index - 1).getFullInfo();
	}

	public Project getSpecificProject(int index, Category category) {
		return sortedByCategoryProjects.get(category).get(index - 1);
	}

	public int projectsInSpecificCategorySize(Category category) {
		return sortedByCategoryProjects.get(category).size();
	}
}