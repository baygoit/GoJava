package kickStarter.Layers;

import java.util.ArrayList;

public class ListOfCategories {
	private ArrayList<Category> names;

	public ArrayList<Category> getNames() {
		return names;
	}

	public void add(Category name) {
		names.add(name);

	}

}
