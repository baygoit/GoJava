package kickstarter;

public class Repository {

	String[] citation = { "null", "Do It", "Go IT", "Create It" };
	String[] users = { "anonymous", "Mike", "Andy" };
	String[] projects = { "null", "Create electrobike", "Paint the fence",
			"Java Architect Training", "Create quadrocopter" };
	String[] categories = { "null", "Technology", "Social", "Education" };
	int[] sequenceOfCategories;

	Repository() {
		sequenceOfCategories = new int[] { 0, 1, 2, 3, 1 };
	}

	void setNameOfCategory(int id, String Name) {
		String[] newCategories = new String[categories.length];
		for (int pointer = 0; pointer < categories.length; pointer++) {
			if (id == pointer) {
				newCategories[pointer]=Name;
			}
			else{
				newCategories[pointer]=categories[pointer];
			}
		}
		categories=newCategories;
	}
}
