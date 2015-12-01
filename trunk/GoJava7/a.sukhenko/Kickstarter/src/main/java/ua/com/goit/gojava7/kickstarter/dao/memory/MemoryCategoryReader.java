package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class MemoryCategoryReader {
	public List<Category> readCategories() {
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

		return categories;

	}
}
