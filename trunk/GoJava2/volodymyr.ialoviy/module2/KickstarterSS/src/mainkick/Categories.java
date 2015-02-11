package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Categories {
	private ArrayList<Category> listCatecories = new ArrayList<Category>();
	private int counterCategory;
	private ArrayList<String[]> categoryBD;
	
	public void readAllCatecories() throws FileNotFoundException{
		categoryBD = readBDCatecories();
    	int i = 0;
		for (String[] value : categoryBD) {
			Category category = new Category();
			getListCatecories().add(category);
		    writeCatecoryInListCategory(i, value);
		    i++;
		}
		setCounterCategory(getListCatecories().size());
	}
	
	public String showAllCatecories() throws FileNotFoundException{
		String s = "";
		for (Category value : listCatecories) {
			s += value.getCategoryID() + " " + value.getCategoryName() + "\n";
			}
		return s.substring(0, s.length() - 1);
	}
	
	private String writeCatecoryInListCategory(int i, String[] value){
		listCatecories.get(i).setCategoryID(Integer.valueOf(value[0]));
		listCatecories.get(i).setCategoryName(value[1]);
		listCatecories.get(i).setProjectsIn(getProjectIn(value[2]));
		return listCatecories.get(i).getCategoryID() + " " + listCatecories.get(i).getCategoryName() + "\n";
	}
	
	private ArrayList<String[]> readBDCatecories() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		return reader.read("Categories.properties");
	}
	
	private int[] getProjectIn(String value) {
		String[] string = value.split(",");
		int[] projectsIn = new int[string.length];
		for (int j = 0; j < string.length; j++){
			projectsIn[j] = Integer.valueOf(string[j]);
		}
		return projectsIn;
	}
	
	public int[] kickContainCategory(){
		int[] kickContainCategories = new int[getCounterCategory()];
		for (int i = 0; i < kickContainCategories.length; i++){
			kickContainCategories[i] = getListCatecories().get(i).getCategoryID();
		}
		return kickContainCategories;
	}
	
	public ArrayList<String[]> getCategoryBD() throws FileNotFoundException{
		return categoryBD;
	}
	
	public int getCounterCategory() {
		return counterCategory;
	}

	public void setCounterCategory(int counterCategory) {
		this.counterCategory = counterCategory;
	}

	public ArrayList<Category> getListCatecories() {
		return listCatecories;
	}

	public void setListCatecories(ArrayList<Category> listCatecories) {
		this.listCatecories = listCatecories;
	}
}