package tyomsky.kickstarter;

public interface Categories {

    int size();

    Category get(int index);

    void add(Category category);

}
