package tyomsky.kickstarter;

public interface CategoriesDAO {

    int size();

    Category get(int index);

    void add(Category category);

}
