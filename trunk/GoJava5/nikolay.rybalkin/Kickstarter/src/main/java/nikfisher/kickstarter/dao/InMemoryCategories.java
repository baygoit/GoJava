package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCategories implements Categories {

    final private Map<Integer, Category> CATEGORIES = new HashMap<>();

    private int index = 0;

    public void add(Category category) {

        CATEGORIES.put(index++, category);
    }

    public List<String> getCategories() {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            result.add(String.valueOf(i + 1) + ") " + CATEGORIES.get(i).getName());
        }
        return result;
    }

    public Category get(int index) {
        return CATEGORIES.get(index);
    }

    public int size() {
        return index;
    }
}
