import java.util.List;

public interface CategoryCatalog {

	public abstract void addCategory(String name);

	public abstract List<String> getCatalog();

	public abstract Category getCategory(int i);

	public abstract int size();

}