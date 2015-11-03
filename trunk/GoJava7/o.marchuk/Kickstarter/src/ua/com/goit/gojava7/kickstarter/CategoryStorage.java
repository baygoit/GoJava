package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryStorage {
	private static final List<String> CATEGORIES = new ArrayList<>();
	{
		CATEGORIES.add("Movie");
		CATEGORIES.add("Dances");
		CATEGORIES.add("Food");
	}

	public List<String> getAllCategories() {
		return Collections.unmodifiableList(CATEGORIES);
	}

}
