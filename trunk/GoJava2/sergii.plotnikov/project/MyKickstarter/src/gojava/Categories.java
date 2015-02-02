package gojava;

import java.util.ArrayList;

public class Categories {
	private ArrayList<MyCategory> categoriesList = new ArrayList<MyCategory>();
		
	public String showList() {
		String result = "";
		int num = 1;
		for(int i = 0; i<categoriesList.size(); i++){
			result+=num + " - " + getCategory(i).getTitle()+"\n";
			num++;
		}
		result+="0 - Go back\n";
		
		return result;
	}
	
	public MyCategory getCategory(int i){
		return categoriesList.get(i);
	}
	
	public int getLength(){
		return categoriesList.size();
	}
	
	public Categories(){
		MyCategory sports = new MyCategory("Sports");
		MyCategory music = new MyCategory("Music");
		MyCategory games = new MyCategory("Games");
		
		categoriesList.add(sports);
		categoriesList.add(music);
		categoriesList.add(games);
		
		Project football = new Project("Football");
		Project basketball = new Project("Basketball");
		
		sports.addProject(football);
		sports.addProject(basketball);
	}

}
