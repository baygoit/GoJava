package pages;

import java.util.ArrayList;

public class CategoryPage implements Page {
	private int categoryIndex;
	private ArrayList<String> page = new ArrayList<String>();

	public CategoryPage(int categoryIndex) {
		this.categoryIndex = categoryIndex;
	}

	@Override
	public ArrayList<String> getPage() {
		// TODO Auto-generated method stub
		return page;
	}

}
