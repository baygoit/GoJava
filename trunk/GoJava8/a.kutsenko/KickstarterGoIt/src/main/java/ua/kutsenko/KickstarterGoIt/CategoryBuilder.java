package ua.kutsenko.KickstarterGoIt;

import java.util.List;

public class CategoryBuilder {
	private Category category;

	public Category getCategory() {
		return category;
	}
    public CategoryBuilder(){
    	this.category = new Category();
    }
    
  /*  public void createAll(List<String> list){
    	for(String name : list){
    		category.getCategoriesList().add(new Category (name));
    	}
    }*/
	
}
