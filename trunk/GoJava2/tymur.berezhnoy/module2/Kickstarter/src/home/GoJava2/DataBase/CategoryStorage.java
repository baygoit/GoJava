package home.GoJava2.DataBase;
import home.GoJava2.Content.Category;
import java.util.List;

public class CategoryStorage {

	private List<Category> listOfCategory;
	
	public CategoryStorage(List<Category> listOfCategory) {
		this.listOfCategory = listOfCategory;
		listOfCategory.add(new Category("Art"));
		listOfCategory.add(new Category("Dance"));
		listOfCategory.add(new Category("Movie"));
		listOfCategory.add(new Category("Crafts"));
		listOfCategory.add(new Category("Programing"));
	}
	
	public void addNewCategoryToStorage(Category category) {
		listOfCategory.add(category);
	}
	
	public List<Category> getListOfCategory() {
		return listOfCategory;
	}
	
	public Category getCategory(int i) {
		return listOfCategory.get(i);
	}
}