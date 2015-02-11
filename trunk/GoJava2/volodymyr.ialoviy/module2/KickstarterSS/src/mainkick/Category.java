package mainkick;

import java.io.FileNotFoundException;

public class Category{
	private int categoryID;
	private String categoryName;
	private int[] projectsIn;

	public String showCatecoryName(int categoryId, Categories categories){
		String categoryName = categories.getListCatecories().get(categoryId).getCategoryName();
		return categoryName;
	}
	
	public int[] projectsContain(int categoryId, Categories categories){
		int[] contain = categories.getListCatecories().get(categoryId).getProjectsIn();
		return contain;
	}
	
	public String showAllProjectInCategory(int i, Projects projects, Categories categories) throws FileNotFoundException{
		String s = "";
		for (int j : categories.getListCatecories().get(i).getProjectsIn()){
			s += projects.showProjectInShort(j) + "\n";				//TODO project поменял на projects
//			s += project.showProjectInShort(j, projects) + "\n";
		}
		return s.substring(0, s.length() - 1);
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int[] getProjectsIn() {
		return projectsIn;
	}

	public void setProjectsIn(int[] projectsIn) {
		this.projectsIn = projectsIn;
	}
}
