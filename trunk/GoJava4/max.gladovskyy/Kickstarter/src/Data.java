import java.util.ArrayList;


public class Data {

	public static Quote getQuote() {
		return new Quote("This is qoute");
	}

	public static ArrayList<Category> getCategorys() {
		return categorys;
	}
	
	private static ArrayList<Category> categorys = generateData();
	
	private static ArrayList<Category> generateData() {
		ArrayList<Category> categorys = new ArrayList<Category>();
		String[] categoryNames = new String[]{"Video","Music","Art","Internet","Sciense"}; 
		
		for (String categoryName: categoryNames) {
			Category category = new Category(categoryName);
			ArrayList<Project> projects = new ArrayList<Project>();
			for (int i = 1; i < 5; i++) {
				projects.add(new Project(categoryName + "project" + i, "decription" + i, 10 * i, 3 * i, i, 
						"hystory", "videolink", "some QA's", category));
			}
			category.setProjects(projects);
			categorys.add(category);
		}
		
		return categorys;
	}

}
