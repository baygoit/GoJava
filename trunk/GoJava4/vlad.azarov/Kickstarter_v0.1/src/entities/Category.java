package entities;

public class Category {
	
	private String[] categoryName;
	private int[] categoryID;
	
	public Category() {
		categoryName = new String[] {
				"[1] Art",
				"[2] Design",
				"[3] Games",
				"[4] Technology"
				};	
	}
	
	
	
	public void showCategoryMenu() {
		System.out.println("CATEGORIES:");
		for(String category : categoryName) {
			System.out.printf("\n\t%s",category);
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
	}
	
	
	
	
		
}
