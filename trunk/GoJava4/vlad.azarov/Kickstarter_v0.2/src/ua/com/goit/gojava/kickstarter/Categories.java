package ua.com.goit.gojava.kickstarter;

public class Categories {

    private Category[] categories = new Category[10];
    private int count = 0;

    public void add(Category category) {
	categories[count] = category;
	count++;
    }

    public String[] getCategories() {
	String[] result = new String[count];
	for (int index = 0; index < this.count; index++) {
	    result[index] = categories[index].getName();
	}
	return result;
    }
}
