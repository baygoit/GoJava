
import java.util.ArrayList;

public class Categories {
	private ArrayList<MyCategory> categoriesList = new ArrayList<MyCategory>();
		
	public void showList() {
		if(categoriesList.size()==0){
			System.out.println("Empty!");
		}
		int num = 1;
		for(int i = 0; i<categoriesList.size(); i++){
			System.out.println(num + " - " + getCategory(i).getTitle());
			num++;
		}
		System.out.println("0 - Go back");
	}
	
	public MyCategory getCategory(int i){
		return categoriesList.get(i);
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
