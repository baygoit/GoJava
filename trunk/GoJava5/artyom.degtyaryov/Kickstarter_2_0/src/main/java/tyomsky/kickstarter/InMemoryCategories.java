package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCategories implements Categories {

    List<Category> data = new ArrayList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Category get(int index) {
        return data.get(index);
    }

    @Override
    public void add(Category category) {
        data.add(category);
    }

}
