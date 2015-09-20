package gojava.InMemory;

import gojava.Interface.Categories;
import gojava.Interface.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InMemoryCategories implements Categories {
	
	private ArrayList<InMemoryCategory> categoriesList = new ArrayList<InMemoryCategory>();

	@Override
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

	@Override
	public Category getCategory(int i){
		return categoriesList.get(i);
	}

	@Override
	public void addCategory(String string) {
		categoriesList.add(new InMemoryCategory(string));
		Collections.sort(categoriesList, new Comparator<InMemoryCategory>() {
	        @Override
	        public int compare(InMemoryCategory cat1, InMemoryCategory cat2)
	        {
	            return  cat1.getTitle().compareTo(cat2.getTitle());
	        }			
	    });
	}
	
	@Override
	public int getLength(){
		return categoriesList.size();
	}

	@Override
	public void fillCategories() {
				
		addCategory("Sports");
		addCategory("Music");
		addCategory("Games");
				
		getCategory(2).addProject("Football");
		getCategory(2).addProject("Basketball");
	}
	

}