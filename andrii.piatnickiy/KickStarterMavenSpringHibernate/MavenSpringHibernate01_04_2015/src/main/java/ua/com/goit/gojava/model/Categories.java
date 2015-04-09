package ua.com.goit.gojava.model;

import java.util.List;

public interface Categories {

        void add(Category category);
        
        List<Category> getCategories();
        
        Category get(int id);

        int size();

}