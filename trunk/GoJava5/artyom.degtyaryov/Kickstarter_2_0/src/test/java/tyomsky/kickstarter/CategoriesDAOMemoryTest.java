package tyomsky.kickstarter;

public class CategoriesDAOMemoryTest extends CategoriesTest{

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
        return new CategoriesDAOMemory();
    }

}