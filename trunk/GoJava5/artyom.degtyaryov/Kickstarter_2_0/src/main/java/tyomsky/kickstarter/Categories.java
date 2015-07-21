package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    List<Category> data = new ArrayList<>();

    public int size() {
        return data.size();
    }

    public Category get(int index) {
        return data.get(index);
    }

    public void add(Category category) {
        data.add(category);
    }
}
