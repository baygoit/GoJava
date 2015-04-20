package com.gojava2.kickstarter.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.Category;
import com.gojava2.kickstarter.entity.Project;
import com.gojava2.kickstarter.entity.Quote;
import com.gojava2.kickstarter.repository.CategoryRepository;
import com.gojava2.kickstarter.repository.ProjectRepository;
import com.gojava2.kickstarter.repository.QuoteRepository;

@Service
@Transactional
public class InitDbService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@PostConstruct
	public void insert() {
		createQuote("Sometimes when you innovate, you make mistakes. "
						+ "It is best to admit them quickly, and get on with improving your other innovations.", "Steve Jobs");
		
		createQuote("The common question that gets asked in business is, why?."
				  + "That is a good question, but an equally valid question is, why not?", "Jeff Bezos");
		
		createQuote("If there is anything that a man can do well, I say let him do it. Give him a chance.", "Abraham Lincoln");
		createQuote("Great leaders, like Steve Jobs or Jeff Bezos, also focused on the long term.", "Reed Hastings");
		createQuote("When you are curious, you find lots of interesting things to do.", "Walt Disney");
		
		Category catgeroryArt = createCategory("Art");
		Category catgeroryComics = createCategory("Comics");
		Category catgeroryDance = createCategory("Dance");
		Category catgeroryGames = createCategory("Games");
		
		createProject("NY artists", "Some description.", 10000, 200, 25, 1, "Here will be history", "http://www.nyart.com", catgeroryArt);
		createProject("The observatory", "Little observatory.", 2000, 100, 17, 1, "Here will be history", "http://www.observatory.com", catgeroryArt);
		createProject("The sing for hope pianos", "The pianos who play in the streat.", 15000, 5000, 4, 30, "Here will be history", "http://www.pianos.com", catgeroryArt);
		createProject("Super Man", "Comic about a man having super powers.", 50000, 1000, 15, 5, "Here will be history", "http://www.superman.com", catgeroryComics);
		createProject("Hulk", "Comics on the green hero named Hulk.", 20000, 100, 50, 2, "Here will be history", "http://www.hulk.com", catgeroryComics);
		createProject("Spider man", "Little - little spider man.", 4000, 200, 40, 1, "Here will be history", "http://www.spiderman.com", catgeroryComics);
		createProject("Dance and Fly", "You can dance, you can fly, we belive in you!", 5000, 1000, 15, 7, "Here will be history", "http://www.df.com", catgeroryDance);
		createProject("Tiny Epic Galaxies", "Develop your empire and colonize planets to create the most powerful galaxy!", 100000, 30000, 50, 17, "Here will be history", "http://www.galaxies.com", catgeroryGames);
		createProject("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG set in 2056s Magically Awakened Hong Kong by the developers of Shadowrun Returns and Dragonfall.", 30000, 2000, 33, 10, "Here will be history", "http://www.shadowrun.com", catgeroryGames);
		createProject("Starr Mazer", "A retro-sexy Point-and-Click Adventure Shoot em Up in SPACE!", 50000, 3000, 20, 6, "Here will be history", "http://www.starr mazer.com", catgeroryGames);
	}
	
	private void createQuote(String content, String author) {
		Quote quote = new Quote(content, author);
		quoteRepository.save(quote);
	}
	
	private Category createCategory(String name) {
		Category category = new Category(name);
		categoryRepository.save(category);
		return category;
	}
	
	private void createProject(String name, String description, int requiredAmount, 
			int total, int daysLeft, int backers, String story, String link, Category category) {
		Project project = new Project(name, description, requiredAmount, total, daysLeft, backers, story, link, category);
		projectRepository.save(project);
	}
}