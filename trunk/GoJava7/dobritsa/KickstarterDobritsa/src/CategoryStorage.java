

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryStorage {

	private static final List<String> CATEGORIES = new ArrayList<String>();
	{
		CATEGORIES.add("Music");
		CATEGORIES.add("Dance");
		CATEGORIES.add("Food");		
	}
	
	public List<String> getAllCategories() {
		return Collections.unmodifiableList(CATEGORIES);		
	}
	
	public String getCategory(int index) {
		return CATEGORIES.get(index);		
	}
	
	// OLEG SRL violated
	public static void printForChoice() {
		System.out.println("\n_________________________________________");
		System.out.println("0: for exit");
		for(int i = 0; i < CATEGORIES.size(); i++) {
			System.out.println(i + 1 + ": " + CATEGORIES.get(i));
		}		
	}	
}
