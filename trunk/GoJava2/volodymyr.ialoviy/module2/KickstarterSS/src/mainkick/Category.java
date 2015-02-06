package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Category{
	private int categoryID;
	private String categoryName;
	private int[] projects;

	public String readCatecory(ArrayList<Category> listCatecories, int i, String[] value) throws FileNotFoundException{
		listCatecories.get(i).categoryID = Integer.valueOf(value[0]);
		listCatecories.get(i).categoryName = value[1];
		String[] string = value[2].split(",");
		listCatecories.get(i).projects = new int[string.length];
		for (int j = 0; j < string.length; j++){
			listCatecories.get(i).projects[j] = Integer.valueOf(string[j]);
		}
		return listCatecories.get(i).categoryID + " " + listCatecories.get(i).categoryName + "\n";
	}

	public String showCatecoryName(int categoryId){
		String categoryName = Categories.listCatecories.get(categoryId).categoryName;
		return categoryName;
	}
	
	public int[] projectsContain(int categoryId){
		int[] contain = Categories.listCatecories.get(categoryId).projects;
		return contain;
	}

	public int[] kickContainCategory(){
		int[] kickContainCategories = new int[Categories.counterCategory];
		for (int i = 0; i < kickContainCategories.length; i++){
			kickContainCategories[i] = Categories.listCatecories.get(i).categoryID;
		}
		return kickContainCategories;
	}
	
	public String showAllProjectInCategory(int i, Project project) throws FileNotFoundException{
		String s = "";
		for (int j : Categories.listCatecories.get(i).projects){
			s += project.showProjectInShort(j) + "\n";
		}
		return s.substring(0, s.length() - 1);
	}
}
