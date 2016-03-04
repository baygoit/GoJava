package ua.nenya.alex.project;

import java.util.ArrayList;
import java.util.List;

public class Project implements GetNameInterface {
	private String name;
	private String description;
	private int allAmount;
	private int availableAmount;
	private int daysRemain;
	private String history = "";
	private String video = "";
	private String questionAnswer = "";
	private List<Project> projectsList = new ArrayList<>();

	public Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public Project() {
	}

	public Project(String name, String description, int allAmount,
			int availableAmount, int daysRemain) {
		this.name = name;
		this.description = description;
		this.allAmount = allAmount;
		this.availableAmount = availableAmount;
		this.daysRemain = daysRemain;
	}
	
	

	public List<Project> getProjectsList() {
		return projectsList;
	}

	public List<Project> getProjects(Category category) {
		List<Project> list = new ArrayList<>();
		for (int i = 0; i < projectsList.size(); i++) {
			Project project = projectsList.get(i);
			if (project.getCategory().getName().equals(category.getName())){
				list.add(project);
			}
		}

		return list;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAllAmount() {
		return allAmount;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public int getDaysRemain() {
		return daysRemain;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public void addInvestition(int i) {
		availableAmount = getAvailableAmount() + i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + allAmount;
		result = prime * result + availableAmount;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + daysRemain;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projectsList == null) ? 0 : projectsList.hashCode());
		result = prime * result + ((questionAnswer == null) ? 0 : questionAnswer.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (allAmount != other.allAmount)
			return false;
		if (availableAmount != other.availableAmount)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (daysRemain != other.daysRemain)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectsList == null) {
			if (other.projectsList != null)
				return false;
		} else if (!projectsList.equals(other.projectsList))
			return false;
		if (questionAnswer == null) {
			if (other.questionAnswer != null)
				return false;
		} else if (!questionAnswer.equals(other.questionAnswer))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	
}
