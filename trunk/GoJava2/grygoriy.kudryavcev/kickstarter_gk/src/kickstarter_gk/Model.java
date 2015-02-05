package kickstarter_gk;

import java.util.ArrayList;

public class Model {

	private int idCat; // TODO id категории
	private ArrayList<Category> allCategories;
	private ArrayList<Project> allProjects;

	public Model(){
		allProjects = new ArrayList<Project>();
		allCategories = new ArrayList<Category>(); 
	}
	
	public void initCategory () {
		// метод первоначального заполнения таблицы с категориями.
		allCategories.add(new Category(0, "Sport",0, "Sport Projects"));
		allCategories.add(new Category(1, "Cinema",0, "Movies Projects"));
		allCategories.add(new Category(2, "HighTech",0, "HighTech Projects"));
		allCategories.add(new Category(3, "Science",0, "Science Projects"));
		allCategories.add(new Category(4, "Health",0, "Health Projects"));
		idCat = 4;
	};
	public void initProjects () {
		allProjects.add(new Project("Project1 name", "Start smthg", 50000, 128, allCategories.get(0)));
		allProjects.add(new Project("Project2 name", "Research smthng", 10000, 150, allCategories.get(0)));
		allProjects.add(new Project("Project3 name", "Research smthng", 20000, 99, allCategories.get(1)));
		allProjects.add(new Project("Project4 name", "Research smthng", 40000, 200, allCategories.get(1)));
		allProjects.add(new Project("Project5 name", "Research smthng", 50000, 500, allCategories.get(3)));
		allProjects.add(new Project("Project6 name", "Research smthng", 60000, 240, allCategories.get(3)));
		
	}

	
	public ArrayList<Project> ProjectList(){
		return allProjects;
	}
	
	public ArrayList<Category> CategoryList(){
		return allCategories;
	}
	
	// Возвращаем список проектов в конкретной категории
	public ArrayList<Project> getProjectInCategory (Category category) {
		ArrayList<Project> projectInCategory = new ArrayList<Project>();
		int i = 0;

		Category cat = category;

		for (i = 0; i < allProjects.size(); i++){

			Category tmpcat = allProjects.get(i).getCategory(); 

			if (cat.equals(tmpcat)) {
				projectInCategory.add(allProjects.get(i));
			}

		}
		
		return projectInCategory;
	}
	
	

	
}
