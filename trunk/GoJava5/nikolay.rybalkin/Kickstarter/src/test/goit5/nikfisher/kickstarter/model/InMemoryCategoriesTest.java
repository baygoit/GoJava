package goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;

public class InMemoryCategoriesTest extends CategoriesTest{

    @Override
    Categories getCategories() {
        return new InMemoryCategories();
    }
}
