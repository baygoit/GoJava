import java.util.ArrayList;
import java.util.List;

public class DataStorage {
	private List<Сategory> categories = new ArrayList<Сategory>();
	public DataStorage() {
		categories.add(new Сategory("Food"));
		categories.add(new Сategory("Music"));
		categories.add(new Сategory("Education"));
	}

	public List<Сategory> getCategoriesList() {
		return categories;
	}
}