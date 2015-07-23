package goit5.nikfisher.kickstarter.model;

public class InFileCategoryTest extends CategoriesTest{
    @Override
    Categories getCategories() {
        return new InMemoryCategories();
    }
}
