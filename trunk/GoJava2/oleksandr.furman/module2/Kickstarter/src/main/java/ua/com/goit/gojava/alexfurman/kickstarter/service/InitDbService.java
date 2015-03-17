package ua.com.goit.gojava.alexfurman.kickstarter.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Category;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Quote;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.CategoryRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.ProjectRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.QuoteRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private CategoryRepository blogRepository;

	@Autowired
	private ProjectRepository itemRepository;
	
	@Autowired
	private QuoteRepository quoteRepository;

	@PostConstruct
	public void init() {

//		Quote quote1 = new Quote();
//		quote1.setQuote("quote1");
//		quoteRepository.save(quote1);
//		
//		Quote quote2 = new Quote();
//		quote2.setQuote("quote2");
//		quoteRepository.save(quote2);
//		
//		Quote quote3 = new Quote();
//		quote3.setQuote("quote3");
//		quoteRepository.save(quote3);
//		
//		Category category1 = new Category();
//		category1.setName("category1");
//		
//		blogRepository.save(category1);
//		
//		Category category2 = new Category();
//		category2.setName("category2");
//		
//		
//		blogRepository.save(category2);
//
//		Project project1 = new Project();
//		project1.setCategory(category1);
//		project1.setName("project1");
//		project1.setDescription("description1");
//		project1.setGoal(20000);
//		project1.setPledged(0);
//		project1.setLinksToVideo("link");
//		project1.setHistory("history1");
//		project1.setDaysLeft(26);
//		project1.setQuestionAnswers("qa1");
//		itemRepository.save(project1);
//
//		Project project2 = new Project();
//		project2.setCategory(category1);
//		project2.setName("project2");
//		project2.setDescription("description2");
//		project2.setGoal(55525);
//		project2.setPledged(0);
//		project2.setLinksToVideo("link2");
//		project2.setHistory("history2");
//		project2.setDaysLeft(54);
//		project2.setQuestionAnswers("qa2");
//		itemRepository.save(project2);
//		
//		Project project3 = new Project();
//		project3.setCategory(category2);
//		project3.setName("project3");
//		project3.setDescription("description3");
//		project3.setGoal(484455);
//		project3.setPledged(0);
//		project3.setLinksToVideo("link3");
//		project3.setHistory("history3");
//		project3.setDaysLeft(34);
//		project3.setQuestionAnswers("qa3");
//		itemRepository.save(project3);
//
//		Project project4 = new Project();
//		project4.setCategory(category2);
//		project4.setName("project4");
//		project4.setDescription("description4");
//		project4.setGoal(11111);
//		project4.setPledged(0);
//		project4.setLinksToVideo("link4");
//		project4.setHistory("history4");
//		project4.setDaysLeft(54);
//		project4.setQuestionAnswers("qa4");
//		itemRepository.save(project4);

	}
}
