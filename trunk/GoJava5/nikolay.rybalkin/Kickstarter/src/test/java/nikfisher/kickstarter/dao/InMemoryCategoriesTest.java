package nikfisher.kickstarter.dao;

public class InMemoryCategoriesTest extends CategoriesTest {

    @Override
    Categories getCategories() {
        return new InMemoryCategories();
    }
}
