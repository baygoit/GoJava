package belskii.artem.kickstarter.dao.category;

import java.util.ArrayList;

public class CategoryDaoImplHardCoding implements CategoryDao {
	private ArrayList<Category> categoryes;

	public CategoryDaoImplHardCoding() {
		categoryes = new ArrayList<Category>();
		Category category1 = new Category(0, "Art");
		Category category2 = new Category(1, "Comics");
		Category category3 = new Category(2, "Crafts");
		Category category4 = new Category(3, "Dance");
		Category category5 = new Category(4, "Design");
		Category category6 = new Category(5, "Fashion");
		Category category7 = new Category(6, "Film & Video");
		Category category8 = new Category(7, "Food");
		Category category9 = new Category(8, "Games");
		Category category10 = new Category(9, "Journalism");
		Category category11 = new Category(10, "Music");
		Category category12 = new Category(11, "Photography");
		Category category13 = new Category(12, "Publishing");
		Category category14 = new Category(13, "Technology");
		Category category15 = new Category(14, "Theater");
		this.addCategory(category1);
		this.addCategory(category2);
		this.addCategory(category3);
		this.addCategory(category4);
		this.addCategory(category5);
		this.addCategory(category6);
		this.addCategory(category7);
		this.addCategory(category8);
		this.addCategory(category9);
		this.addCategory(category10);
		this.addCategory(category11);
		this.addCategory(category12);
		this.addCategory(category13);
		this.addCategory(category14);
		this.addCategory(category15);
	}

	public void addCategory(Category categoryInfo) {
		categoryes.add(categoryInfo);
	}

	public ArrayList<Category> getCategoryList() {
		return categoryes;
	}

	public String getCategoryById(int id) {
		String answer;
		try {
			answer = this.getCategoryList().get(id).toString();
		} catch (Exception IndexOutOfBoundsException) {
			answer = "-1";
		}
		return answer;
	}

}
