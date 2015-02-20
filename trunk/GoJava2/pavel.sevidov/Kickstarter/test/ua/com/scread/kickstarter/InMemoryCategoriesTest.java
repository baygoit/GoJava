package ua.com.scread.kickstarter;

import ua.com.scread.kickstarter.storage.Categories;
import ua.com.scread.kickstarter.storage.InMemoryCategories;

public class InMemoryCategoriesTest extends CategotriesTest {

    @Override
    Categories getCategories() {
        return new InMemoryCategories();
    }

    
}
