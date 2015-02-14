package mainkick;

import java.util.ArrayList;

public class Categories {
	private static final String CATEGORIES_FILE = "Categories.properties";
	private ArrayList<Category> listCatecories = new ArrayList<Category>();
	private int counterCategory;

	
	public void writeAllCatecories(){
		ArrayList<String[]> categoryBD = readDBCatecories();
    	int id = 0;
		for (String[] value : categoryBD) {
			getListCatecories().add(new Category());
		    updateCategory(id, value);
		    id++;
		}
		setCounterCategory(getListCatecories().size());
	}
	
	private String updateCategory(int id, String[] value){
		Category category = listCatecories.get(id);
		category.setCategoryID(Integer.valueOf(value[0]));
		category.setCategoryName(value[1]);
		category.setProjectsIn(getProjectFromCategory(value[2]));
		return category.getCategoryID() + " " + category.getCategoryName() + "\n";
	}
	
	private ArrayList<String[]> readDBCatecories(){
		ReaderDB reader = new ReaderDB();
		return reader.read(CATEGORIES_FILE);
	}
	
	public String getStringAllCatecories(){
		String s = "";
		for (Category value : listCatecories) {
			s += value.getCategoryID() + " " + value.getCategoryName() + "\n";
			}
		return s.substring(0, s.length() - 1);
	}
	
	public String showAllProjectInCategory(int categoryId, Projects projects){
		String s = "";
		Category category = getListCatecories().get(categoryId);
		for (int j : category.getProjects()){
			s += projects.showProjectInShort(j - 1) + "\n";
		}
		return s.substring(0, s.length() - 1);
	}
	
	public String showCatecoryName(int categoryId){
		Category category = getListCatecories().get(categoryId);
		return category.getCategoryName();
	}
	
	private int[] getProjectFromCategory(String value) {
		String[] string = value.split(",");
		int[] projects = new int[string.length];
		for (int j = 0; j < string.length; j++){
			projects[j] = Integer.valueOf(string[j]);
		}
		return projects;
	}
	
	public int[] getKickCategories(){
		int[] kickContainCategories = new int[getCounterCategory()];
		for (int i = 0; i < kickContainCategories.length; i++){
			kickContainCategories[i] = getListCatecories().get(i).getCategoryID();
		}
		return kickContainCategories;
	}
	
	public int[] projectsContain(int categoryId){
		Category category = getListCatecories().get(categoryId);
		return category.getProjects();
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