package goit5.nikfisher.kickstarter.model;

public interface Categories {

    void add(Category category);

    String[] getCategories();

    Category get(int index);

    int size();
}
