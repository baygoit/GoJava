package ua.com.goit.gojava.kickstarter.in_memory_storage;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.CategoryCatalog;

public class InMemoryCategoryCatalog implements CategoryCatalog {
	private Set<Category> categoryCatalog = new LinkedHashSet<>();

	@Override
	public void addCategory(String name) {
		categoryCatalog.add(new InMemoryCategory(name));
	}

	@Override
	public List<String> getCatalog() {
		ArrayList<String> list = new ArrayList<>();
		for (Category t : categoryCatalog)
			list.add(t.getName());
		return list;
	}

	@Override
	public Category getCategory(int i) {
		Category[] categoryCatalog = this.categoryCatalog
				.toArray(new Category[size()]);
		return categoryCatalog[i];
	}

	@Override
	public int size() {
		return categoryCatalog.size();
	}

}
