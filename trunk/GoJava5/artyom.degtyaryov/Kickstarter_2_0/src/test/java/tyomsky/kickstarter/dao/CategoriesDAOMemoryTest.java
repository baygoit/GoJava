package tyomsky.kickstarter.dao;

public class CategoriesDAOMemoryTest extends CategoriesTest {

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
        return new CategoriesDAOMemory();
    }

}