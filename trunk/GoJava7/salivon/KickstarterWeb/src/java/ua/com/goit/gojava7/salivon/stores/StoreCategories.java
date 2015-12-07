package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;

public class StoreCategories {

    static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category("Art", 1));
        categories.add(new Category("Comics", 2));
        categories.add(new Category("Games", 3));
    }

    public static List<Category> getCategories() {
        return categories;
    }

}
