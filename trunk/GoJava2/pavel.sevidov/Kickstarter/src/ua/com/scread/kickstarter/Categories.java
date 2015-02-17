package ua.com.scread.kickstarter;

import java.util.List;

public interface Categories {

    abstract void add(Category category);

    abstract int size();

    abstract List<Category> getCategories();

    abstract Category getCategory(int index);
    
    abstract String[] getStringCategories();

}