package tyomsky.kickstarter.dao;

public class CategoriesDAOMemoryTest extends CategoriesDAOTest {

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
        return new CategoriesDAOMemory();
    }

}