package com.gojava2.kickstarter.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.Category;
import com.gojava2.kickstarter.entity.Project;
import com.gojava2.kickstarter.entity.ProjectStatus;
import com.gojava2.kickstarter.entity.Quote;
import com.gojava2.kickstarter.entity.User;
import com.gojava2.kickstarter.repository.CategoryRepository;
import com.gojava2.kickstarter.repository.ProjectRepository;
import com.gojava2.kickstarter.repository.ProjectStatusRepository;
import com.gojava2.kickstarter.repository.QuoteRepository;
import com.gojava2.kickstarter.repository.UserRepository;

@Service
@Transactional
public class InitDbService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectStatusRepository statusRepository;
	
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
		
		User user = createUser("Timur", "smth", "12345");
		
		createProject("NY artists", "Some description.", "Here will be history", "http://www.nyart.com", catgeroryArt, createStatus(50000, 10000, 40, 13), user);
		createProject("The observatory", "Little observatory.", "Here will be history", "http://www.observatory.com", catgeroryArt, createStatus(25000, 4000, 60, 10), user);
		createProject("The sing for hope pianos", "The pianos who play in the streat.", "Here will be history", "http://www.pianos.com", catgeroryArt, createStatus(70000, 30000, 30, 17), user);
		createProject("Super Man", "Comic about a man having super powers.", "Here will be history", "http://www.superman.com", catgeroryComics, createStatus(60000, 100, 70, 1), user);
		createProject("Hulk", "Comics on the green hero named Hulk.", "Here will be history", "http://www.hulk.com", catgeroryComics, createStatus(5000, 900, 25, 1), user);
		createProject("Spider man", "Little - little spider man.", "Here will be history", "http://www.spiderman.com", catgeroryComics, createStatus(100000, 8000, 70, 9), user);
		createProject("Dance and Fly", "You can dance, you can fly, we belive in you!", "Here will be history", "http://www.df.com", catgeroryDance, createStatus(10000, 1000, 15, 1), user);
		createProject("Tiny Epic Galaxies", "Develop your empire and colonize planets to create the most powerful galaxy!", "Here will be history", "http://www.galaxies.com", catgeroryGames, createStatus(100000, 8000, 70, 9), user);
		createProject("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG set in 2056s Magically Awakened Hong Kong by the developers of Shadowrun Returns and Dragonfall.", "Here will be history", "http://www.shadowrun.com", catgeroryGames, createStatus(100000, 8000, 70, 9), user);
		createProject("Starr Mazer", "A retro-sexy Point-and-Click Adventure Shoot em Up in SPACE!", "Here will be history", "http://www.starr mazer.com", catgeroryGames, createStatus(100000, 8000, 70, 9), user);
		
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
	
	private void createProject(String name, String description, String story, String link, Category category, ProjectStatus status, User user) {
		Project project = new Project(name, description, story, link, category, status, user);
		projectRepository.save(project);
	}
	
	private User createUser(String name, String email, String password) {
		User user = new User(name, email, password);
		userRepository.save(user);
		return user;
	}
	
	private ProjectStatus createStatus(int requiredAmount, int total, int daysLeft, int backers) {
		ProjectStatus status = new ProjectStatus(requiredAmount, total, daysLeft, backers);
		statusRepository.save(status);
		return status;
	}
}