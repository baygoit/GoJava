package ua.goit.goitjava.kickstarter;

public class CategoryService {
	CategoriesDB cat = new CategoriesDB ();
	Output out = new Output();
	
	public void showAllCategories(){
		out.printAllCategories(cat.getAllCategories());
	}
	
	public void printCategoryByID(int id){
		Category category = cat.getSelectCategories(id);
		out.printSelectCategory(category);
	}
}
