import java.util.ArrayList;
import java.util.List;

public class CategoryStorage {
	private List<Сategory> categories = new ArrayList<Сategory>();

    public CategoryStorage() {
        categories.add(new Сategory("Food"));
        categories.add(new Сategory("Music"));
        categories.add(new Сategory("Education"));
    }

    public List<Сategory> getCategoriesList() {
        return categories;
    }
}