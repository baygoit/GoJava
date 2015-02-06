package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Categories {
	private ArrayList<Category> listCatecories = new ArrayList<Category>();
	private int counterCategory;
	
	public String readAllCatecories() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		ArrayList<String[]> categoryBD = reader.read("Categories.properties");
    	int i = 0;
		String s = "";
		for (String[] value : categoryBD) {
			listCatecories.add(new Category());
			listCatecories.get(i).categoryID = Integer.valueOf(value[0]);
			listCatecories.get(i).categoryName = value[1];
			String[] string = value[2].split(",");
			listCatecories.get(i).projectsThatContain = new int[string.length];
			for (int j = 0; j < string.length; j++){
				listCatecories.get(i).projectsThatContain[j] = Integer.valueOf(string[j]);
			}
		    s += listCatecories.get(i).categoryID + " " + listCatecories.get(i).categoryName + "\n";
		    i++;
		}
		counterCategory = listCatecories.size();
		return s.substring(0, s.length() - 1);
	}
	
	public String showCatecoryName(int categoryId){
		String name = listCatecories.get(categoryId).categoryName;
		return name;
	}
	
	public int[] projectsContain(int categoryId){
		int[] contain = listCatecories.get(categoryId).projectsThatContain;
		return contain;
	}
	
	public int[] kickContainCategory(){
		int[] kickContainCategories = new int[counterCategory];
		for (int i = 0; i < kickContainCategories.length; i++){
			kickContainCategories[i] = listCatecories.get(i).categoryID;
		}
		return kickContainCategories;
	}
	
	public String showAllProjectInCategory(int i, Projects projects) throws FileNotFoundException{
		String s = "";
//		Projects projects = new Projects();
		for (int j : listCatecories.get(i).projectsThatContain){
			s += projects.showProjectInShort(j) + "\n";
		}
		return s.substring(0, s.length() - 1);
	}
	
}
