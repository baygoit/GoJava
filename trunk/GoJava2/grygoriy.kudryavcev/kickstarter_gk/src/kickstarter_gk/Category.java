package kickstarter_gk;

import java.util.ArrayList;

public class Category {

	public int idCat;
	public String NameCategory;
	public int CountProject;
	
	public Category (int idCat, String NameCategory, int CountProject) {
		this.idCat = idCat;
		this.NameCategory = NameCategory;
		this.CountProject = CountProject;
	}
	 
	
	
	public String getNameCategory () {
		return NameCategory;
	}
	 
	public int getCountProject () {
		return CountProject;
	}
		
	
	public void del (String category) {
		;
		
	}
	
	
}
