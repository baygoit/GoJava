package kickstarter;

import java.util.ArrayList;

public class CategoryList {
	private Output out = new Output();
	private static ArrayList<Category> categoryList = new ArrayList<Category>();

	public CategoryList() {
		categoryList.add(new Category(1, "Sport"));
		categoryList.add(new Category(2, "Music"));
		categoryList.add(new Category(3, "Technology"));
	}

	public void showCategories() {
		out.print("\n ••••• Select a category: •••••\n");
	
		for (int j = 0; j < categoryList.size(); j++) {
			out.print(categoryList.get(j).toString());
		}
	}
	
	public Category getCategory(int i) {
		return categoryList.get(i);
	}

	
}
