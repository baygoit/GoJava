package com.kickstarter.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.User;
import com.kickstarter.util.Utils;

public class ProjectDAO extends CommonDAO<Project> {

	private CategoryDAO categoryDAO;	
	private FaqDAO faqDAO;
	
	public ProjectDAO() {
		categoryDAO = new CategoryDAO();
		faqDAO = new FaqDAO();
		
		addElementToDataSource("Xpand Lacing System",
				"Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!", 
				"25.10.2015",
				"Charles Harris",
				"Sports");
		
		addElementToDataSource("Draw Like a Boss : The Physical Book",
				"Two years in the making and it's finally ready to become a physical instructional book about drawing.", 
				"11.10.2015",
				"Ash and Eli", 
				"Art");
		
		addElementToDataSource("Mini Museum 2: The Second Edition",
				"Billions of years of life, science and history in the palm of your hand! Curated and handcrafted to inspire for generations.", 
				"30.10.2015",
				"Hans Fex", 
				"Art");
		
		addElementToDataSource("FlyKly Smart Ped",
				"This beautifully practical kick assist e-bike is the smartest move around the city as it extends your ride and folds easily.", 
				"30.10.2015",
				"FlyKly", 
				"Sports");
		
		addElementToDataSource("Music for Cats",
				"We need your help to create an album featuring the first-ever music scientifically proven to enrich cats' lives.", 
				"28.10.2015",
				"David Teie", 
				"Music");
	}

	private void addElementToDataSource(String projectName, String projectDescription, String projectDate,
			String userName, String categoryName) {
		
		Random rnd = new Random();
		
		Project project = new Project();
		project.setName(projectName);
		project.setAuthor(new User(userName, ""));

		project.setDescription(projectDescription);
		// project.setVideoUrl(videoUrl);
		project.setStartDate(Utils.dateFromString("dd.MM.yyyy", projectDate));
		project.setEndDate(Utils.addToDate(project.getStartDate(), 1, Calendar.MONTH));
		project.setGoalSum(rnd.nextInt(100)*100L);
		project.setBalanceSum(rnd.nextInt(100)*100L);
		// project.setRewards(rewards);
		
		project.setQuestionsAndAnswers(faqDAO.getAll());

		project.addCategory(categoryDAO.getByName(categoryName));
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
