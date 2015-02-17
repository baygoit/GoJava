package kickstarter_gk;

import java.util.ArrayList;

public class Category {

	public int idCat;
	public String NameCategory;
	public int CountProject;
	public String description;

	public Category(int idCat, String NameCategory, int CountProject,
			String description) {
		this.idCat = idCat;
		this.NameCategory = NameCategory;
		this.CountProject = CountProject;
		this.description = description;
	}

	public int getId(Category category) {
		return idCat;
	}

	public String getNameCategory() {
		return NameCategory;
	}

	public int getCountProject() {
		return CountProject;
	}

	public String toString() {
		return NameCategory + "," + description;
	}

	public void del(String category) {

	}

}
