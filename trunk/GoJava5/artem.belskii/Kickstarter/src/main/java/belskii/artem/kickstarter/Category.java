package belskii.artem.kickstarter;

import java.util.ArrayList;

public class Category {
	private ArrayList<String> categoryList = new ArrayList<String>();
	
	public void addCategory(String catName) {
		categoryList.add(catName);
	}

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}
	
}
