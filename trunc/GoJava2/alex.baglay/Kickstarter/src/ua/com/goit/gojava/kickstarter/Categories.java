package ua.com.goit.gojava.kickstarter;

public class Categories {

	private Category[] categories = new Category[10]; // ах вот оно откуда!! я захардкодил... TODO
	private int count = 0;
	
	public void add(Category category) {
		categories[count] = category;
		count++; 
	}
	
	public String[] getCategories() {
		String[] result = new String[count];
		for (int index = 0; index < count; index++) {
			result[index] = String.valueOf(index) + " - " + categories[index].getName();
		}
		
		return result;
	}

	public Category get(int index) { 
		return categories[index];  
	}

	public int size() {
		return count;
	}

}
