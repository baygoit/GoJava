
public class —ategories {

	private Category[] categories = new Category[10];
	private int index = 0;
	
	public void add(Category category) {
		categories[index] = category;
		index++;
	}
	
	public String[] get—ategories(){
		
		String[] result = new String[index];
		
		for (int i = 0; i < index; i++) {
			result[i] = String.valueOf(i) + ") " + categories[i].getName();
		}
		
		return result;
	}

	public String getName(int index) {
		return categories[index].getName();
	}
}
