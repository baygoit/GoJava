package model;

import java.util.ArrayList;

public class ProjectRepository {

	private ArrayList<Project> projects;
	private int storageSize;

	public ProjectRepository() {
		projects = new ArrayList<>();
		CategoryRepository categoryRepository = new CategoryRepository();
		ArrayList<String> questionsAndAnswersList = new QuestionsAndAnswersRepository()
				.getQuestionsAndAnswers();

		String[] questionsAndAnswers = makeStringsFromArrayList(questionsAndAnswersList);

		Category videoCategory = categoryRepository.getCategoies().get(0);

		add(new Project("First Video Project", "it is short description of it",
				15000, 3698, 100, videoCategory, "history of the project",
				questionsAndAnswers));
		add(new Project("Second Video Project",
				"it is short description of it", 320000, 12020, 200,
				videoCategory, "history of the project", questionsAndAnswers));
		add(new Project("Third Video Project", "it is short description of it",
				64000, 20, 300, videoCategory, "history of the project",
				questionsAndAnswers));
		add(new Project("4th Video Project", "it is short description of it",
				128000, 10, 400, videoCategory, "history of the project",
				questionsAndAnswers));

		Category audioCategory = categoryRepository.getCategoies().get(1);

		add(new Project("First Audio Project",
				"it is short description of the Audio Project", 1000, 10999,
				100, audioCategory, "history of the project",
				questionsAndAnswers));
		add(new Project("Second Audio Project",
				"it is short description of the Audio Project", 2000, 2999,
				200, audioCategory, "history of the project",
				questionsAndAnswers));
		add(new Project("Third Audio Project",
				"it is short description of the Audio Project", 3000, 3999,
				300, audioCategory, "history of the project",
				questionsAndAnswers));
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void add(Project project) {
		projects.add(project);
		storageSize++;
	}

	public Project[] getProjectsOfChosenCategory(Category category) {
		Project[] result = new Project[storageSize];
		int numberOfProjectsInThisCategory = 0;
		for (int index = 0; index < storageSize; index++) {
			Project currentProject = projects.get(index);
			if (currentProject.getCategory().equals(category)) {
				result[numberOfProjectsInThisCategory] = currentProject;
				numberOfProjectsInThisCategory++;
			}
		}
		return result;
	}
	
	private String[] makeStringsFromArrayList(ArrayList<String> arrayList) {
		int listSize = arrayList.size();
		String[] resultArray = new String[listSize];
		for (int index = 0; index < listSize; index++) {
			resultArray[index] = arrayList.get(index);
		}
		return resultArray;
	}
}
