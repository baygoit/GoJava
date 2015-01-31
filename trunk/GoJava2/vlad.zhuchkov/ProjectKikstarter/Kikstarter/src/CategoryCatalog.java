import java.util.ArrayList;

public class CategoryCatalog {
	private ArrayList<Category> categoryCatalog = new ArrayList<>();
	
	public void addCategory(String name) {
		categoryCatalog.add(new Category(name));
	}

	public ArrayList<Category> getCatalogList() {
		return categoryCatalog;
	}

	public Category getCategory(int i) {
		Input reader = new Reader(new Printer());
		while (i >= categoryCatalog.size()||i<0) {
				System.out.println("Illigal category number. Try again");
				i = reader.readInt()-1;
				} 
		return categoryCatalog.get(i);
	}

	public int size() {
		return categoryCatalog.size();
	}
}
