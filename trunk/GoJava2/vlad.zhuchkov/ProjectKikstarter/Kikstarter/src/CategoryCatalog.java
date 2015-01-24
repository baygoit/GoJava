import java.util.ArrayList;

public class CategoryCatalog {
	private ArrayList<Category> categoryCatalog = new ArrayList<>();

	public void addCategory(Category name) {
		categoryCatalog.add(name);
	}

	public ArrayList<Category> getCatalogList() {
		return categoryCatalog;
	}

	public Category getCategory(int i) {
		return categoryCatalog.get(i);
	}

	public int size() {
		return categoryCatalog.size();
	}
}
