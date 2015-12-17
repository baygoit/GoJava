package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.util;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class Memory {
	private List<Quote> quotes = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	
	public Memory() {
		initQuotes();
		initCategiries();
		initProjects();
	}
	
	private void initQuotes() {
		Quote quote1 = new Quote();
		quote1.setText("Your work is going to fill a large part of your life");
		quote1.setAuthor("Steve Jobs");
		quotes.add(quote1);
		
		Quote quote2 = new Quote();
		quote2.setText("Innovation distinguishes between a leader and a follower");
		quote2.setAuthor("Steve Jobs");
		quotes.add(quote2);
	}

	private void initCategiries() {
		Category movie = new Category();
		movie.setCategoryName("Movie");
		categories.add(movie);
		
		Category art = new Category();
		art.setCategoryName("Art");
		categories.add(art);
		
		Category food = new Category();
		food.setCategoryName("Food");
		categories.add(food);
	}

	private void initProjects() {
		Project boondockSaints = new Project();

		boondockSaints.setProjectName("Boondock Saints");
		boondockSaints.setIdParentCategory(1);
		boondockSaints.setProjectCostNeed(15000000);
		boondockSaints.setDeadline(180);
		boondockSaints.setProjectShortDescription("The Boondock Saints is a 1999 American crime film");
		boondockSaints
				.setProjectDescription("The MacManus brothers are living a quiet life in Ireland with their father.");
		boondockSaints.setVideoUrl("http://youtube.com/boondocksaints");

		projects.add(boondockSaints);

		Project pulpFiction = new Project();
		pulpFiction.setProjectName("Pulp Fiction");
		pulpFiction.setIdParentCategory(1);
		pulpFiction.setProjectCostNeed(2000000);
		pulpFiction.setDeadline(210);
		pulpFiction.setProjectShortDescription("Jules Winnfield and Vincent Vega are two hitmen.");
		pulpFiction.setProjectDescription("The lives of two mob hit men, a boxer, a gangster's wife.");
		pulpFiction.setVideoUrl("http://youtube.com/pulpfiction");
		
		projects.add(pulpFiction);
		
		Project artGallery = new Project();
		artGallery.setProjectName("Art Gallery");
		artGallery.setIdParentCategory(2);
		artGallery.setProjectCostNeed(400000);
		artGallery.setDeadline(80);
		artGallery.setProjectShortDescription("Art Gallery in town");
		artGallery.setProjectDescription("Art Gallery in town near something");
		artGallery.setVideoUrl("http://youtube.com/artgallery");

		projects.add(artGallery);
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Project> getProjects() {
		return projects;
	}
	
}
