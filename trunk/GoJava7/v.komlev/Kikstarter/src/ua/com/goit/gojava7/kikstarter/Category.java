package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create class Category which contain list categories
 * 
 */
public class Category {

	protected static List<String> listCategoies = new ArrayList<>();
	private Map<Integer, String> mapCategory = new HashMap<>();

	public Category() {
		setMapCategory();
	}

	private void setMapCategory() {
		mapCategory.put(1, "Photo");
		mapCategory.put(2, "Movie");
		mapCategory.put(3, "Record");
	}

	public void getMapCategory() {
		for (Map.Entry<Integer, String> entry : mapCategory.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
