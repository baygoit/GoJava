package com.kickstarter.dao;

import java.util.Date;

import com.kickstarter.beans.Project;
import com.kickstarter.beans.User;

public class ProjectDAO extends CommonDAO<Project> {

	public ProjectDAO() {
		Project project = new Project();
		project.setName("Xpand Lacing System");
		project.setAuthor(new User("Charles Harris", ""));
		//project.setCategories(categories);
		project.setDescription("Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!");
		//project.setVideoUrl(videoUrl);
		project.setStartDate(new Date());
		//project.setEndDate(endDate);			
		project.setGoalSum(10_000L);
		project.setBalanceSum(296_856L);
		//project.setRewards(rewards);
		dataSource.add(project);
	}

}
