package model;

import java.util.ArrayList;

public class CategoriesFromFile implements Categories {
	private static final String CATEGORIES_FILE = "Categories.properties";
	private ArrayList<Category> listCatecories = new ArrayList<Category>();
	private int counterCategory;
	

	@Override
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
	
	@Override
	public String showAllCatecoriesInKickstarter(){
		StringBuilder s = new StringBuilder();
		for (Category value : listCatecories) {
			s.append(value.getCategoryID()).append(" ").append(value.getCategoryName()).append("\n").toString();
			}
		return s.substring(0, s.length() - 1);
	}
	
	@Override
	public String showAllProjectInCategory(int categoryId, Projects projects){
		StringBuilder s = new StringBuilder();
		Category category = getListCatecories().get(categoryId - 1);
		for (int j : category.getProjects()){
			s.append(projects.showProjectInShort(j - 1)).append("\n").toString();
		}
		return s.substring(0, s.length() - 1);
	}
	
	@Override
	public String showCatecoryName(int categoryId){
		Category category = getListCatecories().get(categoryId - 1);
		return category.getCategoryName();
	}
	
	@Override
	public int[] getKickCategories(){
		int[] kickContainCategories = new int[getCounterCategory()];
		for (int i = 0; i < kickContainCategories.length; i++){
			kickContainCategories[i] = getListCatecories().get(i).getCategoryID();
		}
		return kickContainCategories;
	}
	
	@Override
	public int[] projectsThatAreContainedInTheCategory(int categoryId){
		Category category = getListCatecories().get(categoryId - 1);
		return category.getProjects();
	}
	
	@Override
	public int getCounterCategory() {
		return counterCategory;
	}

	@Override
	public void setCounterCategory(int counterCategory) {
		this.counterCategory = counterCategory;
	}

	@Override
	public ArrayList<Category> getListCatecories() {
		return listCatecories;
	}

	@Override
	public void setListCatecories(ArrayList<Category> listCatecories) {
		this.listCatecories = listCatecories;
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
	
	private int[] getProjectFromCategory(String value) {
		String[] string = value.split(",");
		int[] projects = new int[string.length];
		for (int j = 0; j < string.length; j++){
			projects[j] = Integer.valueOf(string[j]);
		}
		return projects;
	}
}