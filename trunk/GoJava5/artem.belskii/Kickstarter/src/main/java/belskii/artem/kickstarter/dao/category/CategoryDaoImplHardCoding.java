package belskii.artem.kickstarter.dao.category;

import java.util.ArrayList;

public class CategoryDaoImplHardCoding implements CategoryDao {
	private ArrayList<Category> categoryes;

	public CategoryDaoImplHardCoding() {
		categoryes = new ArrayList<Category>();
		this.addCategory(new Category(0, "Art"));
		this.addCategory(new Category(1, "Comics"));
		this.addCategory(new Category(2, "Crafts"));
		this.addCategory(new Category(3, "Dance"));
		this.addCategory(new Category(4, "Design"));
		this.addCategory(new Category(5, "Fashion"));
		this.addCategory(new Category(6, "Film & Video"));
		this.addCategory(new Category(7, "Food"));
		this.addCategory(new Category(8, "Games"));
		this.addCategory(new Category(9, "Journalism"));
		this.addCategory(new Category(10, "Music"));
		this.addCategory(new Category(11, "Photography"));
		this.addCategory(new Category(12, "Publishing"));
		this.addCategory(new Category(13, "Technology"));
		this.addCategory(new Category(14, "Theater"));
	}

	public void addCategory(Category categoryInfo) {
		categoryes.add(categoryInfo);
	}

	public ArrayList<Category> getCategoryList() {
		return categoryes;
	}

	public String getCategoryNameById(int id) {
		String answer;
		try {
			answer = this.getCategoryList().get(id).getCategoryName();
		} catch (Exception IndexOutOfBoundsException) {
			answer = "-1";
		}
		return answer;
	}

}
