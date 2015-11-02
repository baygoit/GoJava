package com.kickstarter.dao;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.User;
import com.kickstarter.util.Utils;

public class ProjectDAO extends CommonDAO<Project> {

	public ProjectDAO() {

		Project project = new Project();
		project.setName("Xpand Lacing System");
		project.setAuthor(new User("Charles Harris", ""));
		// project.setCategories(categories);
		project.setDescription("Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!");
		// project.setVideoUrl(videoUrl);
		project.setStartDate(Utils.dateFromString("dd.MM.yyyy", "25.10.2015"));
		project.setEndDate(Utils.addToDate(project.getStartDate(), 1, Calendar.MONTH));
		project.setGoalSum(10_000L);
		project.setBalanceSum(296_856L);
		// project.setRewards(rewards);
		
		project.addCategory(new CategoryDAO().getAll().get(0));
		dataSource.add(project);
	}

	public List<Project> getByCategory(Category category) {
		List<Project> filteredProjects = dataSource.stream().filter(project -> {
			for (Category element : project.getCategories()) {
				if (element.equals(category)) {
					return true;
				}
			}
			return false;
		}).collect(Collectors.toList());
		return filteredProjects;
	}

}
