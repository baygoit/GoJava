package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class MemoryCategoryReader {
	public List<Category> readCategories(){
		List<Category> categories = new ArrayList<Category>();
		Category movie = new Category();
		movie.setCategoryId(1);
		movie.setCategoryName("Movies");
		
		
		Category technology = new Category();
		movie.setCategoryId(2);
		movie.setCategoryName("Technology");
		
		Category games = new Category();
		movie.setCategoryId(3);
		movie.setCategoryName("Games");
		
		Category books = new Category();
		movie.setCategoryId(4);
		movie.setCategoryName("Books");
		
		categories.add(movie);
		categories.add(technology);
		categories.add(games);
		categories.add(books);
		
		
		
		LocalDateTime dateTime = LocalDateTime.now();
		Project catana = new Project("Catana", "New sword-fighting game", games,
				dateTime.plusDays(14));
		new Project("Terminator Exodus", "New game about fighting as Terminator",
				movie, dateTime);
		Project project = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group",
				movie, LocalDateTime.now().plusHours(23));

		catana.setDemoLink("www.catana.game");
		catana.getPaymentBonus().getBonuses().put(1, "You will be mentioned in the project");
		catana.getPaymentBonus().getBonuses().put(10, "Tea Cup with Catana + mentioned in the project");
		catana.getPaymentBonus().getBonuses().put(40, "Same as for 10$ + Early Access pack.");
		Map<String, String> qa = new HashMap<String, String>();
		qa.put("What is project about?", "It is about our goit7 group");
		qa.put("When was it started", "October 2015");
		catana.setQuestionsAndAnswers(qa);

		
		return null;
		
	}
}
