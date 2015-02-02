package ua.com.goit.gojava.kickstarter;

public class Categories {

	private Category[] categories = new Category[10]; // ах вот оно откуда!! я захардкодил... TODO
	private int count = 0;
	
	// этот метод потестили 
	public void add(Category category) {
		categories[count] = category;
		count++; 
	}
	
	// этот тоже
	public String[] getCategories() {
		String[] result = new String[count];
		for (int index = 0; index < count; index++) {
			result[index] = String.valueOf(index + 1) + " - " + categories[index].getName();
		}
		
		return result;
	}

	// и этот
	public Category get(int index) { 
		return categories[index];  
	}

	// теперь и этот
	public int size() {
		return count;
	}

}
