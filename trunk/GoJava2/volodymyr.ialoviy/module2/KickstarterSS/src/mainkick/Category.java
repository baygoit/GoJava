package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Category{
	private int categoryID;
	private String categoryName;
	private int[] projectsIn;

	public String readCatecory(ArrayList<Category> listCatecories, int i, String[] value) throws FileNotFoundException{
		listCatecories.get(i).categoryID = Integer.valueOf(value[0]);
		listCatecories.get(i).categoryName = value[1];
		String[] string = value[2].split(",");
		listCatecories.get(i).projectsIn = new int[string.length];
		for (int j = 0; j < string.length; j++){
			listCatecories.get(i).projectsIn[j] = Integer.valueOf(string[j]);
		}
		return listCatecories.get(i).categoryID + " " + listCatecories.get(i).categoryName + "\n";
	}

	public String showCatecoryName(int categoryId, Categories categories){
		String categoryName = categories.getListCatecories().get(categoryId).categoryName;
		return categoryName;
	}
	
	public int[] projectsContain(int categoryId, Categories categories){
		int[] contain = categories.getListCatecories().get(categoryId).projectsIn;
		return contain;
	}

	public int[] kickContainCategory(Categories categories){
		int[] kickContainCategories = new int[categories.getCounterCategory()];
		for (int i = 0; i < kickContainCategories.length; i++){
			kickContainCategories[i] = categories.getListCatecories().get(i).categoryID;
		}
		return kickContainCategories;
	}
	
	public String showAllProjectInCategory(int i, Project project, Projects projects, Categories categories) throws FileNotFoundException{
		String s = "";
		for (int j : categories.getListCatecories().get(i).projectsIn){
			s += project.showProjectInShort(j, projects) + "\n";
		}
		return s.substring(0, s.length() - 1);
	}
}
