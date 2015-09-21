package goit.nz.kickstarter.model;

import goit.nz.kickstarter.domain.Category;
import goit.nz.kickstarter.domain.FAQ;
import goit.nz.kickstarter.domain.Project;
import goit.nz.kickstarter.domain.ProjectEvent;
import goit.nz.kickstarter.domain.RewardOption;

import java.util.List;

public class ProjectModel {
	private Project project;
	private List<FAQ> faqs;
	private List<ProjectEvent> events;
	private List<RewardOption> rewards;
	private Category category;

	public void setFaqs(List<FAQ> faqs) {
		this.faqs = faqs;
	}

	public void setEvents(List<ProjectEvent> events) {
		this.events = events;
	}

	public void setRewardOptions(List<RewardOption> rewards) {
		this.rewards = rewards;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public List<FAQ> getFaqs() {
		return faqs;
	}

	public List<ProjectEvent> getEvents() {
		return events;
	}

	public List<RewardOption> getRewardOptions() {
		return rewards;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}

}
