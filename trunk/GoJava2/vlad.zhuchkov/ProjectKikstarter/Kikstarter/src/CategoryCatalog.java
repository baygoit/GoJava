import java.util.LinkedHashSet;
import java.util.Set;

public class CategoryCatalog {
	private Set<Category> categoryCatalog = new LinkedHashSet<>();
	
	public void addCategory(String name) {
		categoryCatalog.add(new Category(name));
	}

	public Category[] getCatalogList() {
		return categoryCatalog.toArray(new Category[size()]);
	}

	public Category getCategory(int i) {
		Category[] categoryCatalog = getCatalogList();
		return categoryCatalog[i];
	}

	public int size() {
		return categoryCatalog.size();
	}
	
}
