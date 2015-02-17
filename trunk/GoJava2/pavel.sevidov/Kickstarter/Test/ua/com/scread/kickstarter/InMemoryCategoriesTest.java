package ua.com.scread.kickstarter;

public class InMemoryCategoriesTest extends CategotriesTest {

    @Override
    Categories getCategories() {
        return new InMemoryCategories();
    }

    
}
