package gojava;

import java.util.ArrayList;

public class Categories {
	private ArrayList<Category> categoriesList = new ArrayList<Category>();
		
	public String showCategories() {
		String result = "";
		int num = 1;
		for(int i = 0; i<categoriesList.size(); i++){
			result+=num + " - " + getCategory(i).getTitle()+"\n";
			num++;
		}
		result+="0 - Go back\n";
		
		return result;
	}
	
	public Category getCategory(int i){
		return categoriesList.get(i);
	}

	public void addCategory(Category category) {
		categoriesList.add(category);
	}
	
	public int getLength(){
		return categoriesList.size();
	}

	public void fillCategories() {
		Category sport = new Category("Sports");
		Category music = new Category("Music");
		Category games = new Category("Games");
		
		categoriesList.add(sport);
		categoriesList.add(music);
		categoriesList.add(games);
		
		Project football = new Project("Football");
		Project basketball = new Project("Basketball");
		
		sport.addProject(football);
		sport.addProject(basketball);
		
	}
	
	
	
}
