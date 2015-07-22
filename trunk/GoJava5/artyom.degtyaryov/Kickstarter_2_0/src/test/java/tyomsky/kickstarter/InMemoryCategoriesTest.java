package tyomsky.kickstarter;

import static org.junit.Assert.*;

public class InMemoryCategoriesTest extends CategoriesTest{

    @Override
    public Categories getCategoriesImplementation() {
        return new InMemoryCategories();
    }

}