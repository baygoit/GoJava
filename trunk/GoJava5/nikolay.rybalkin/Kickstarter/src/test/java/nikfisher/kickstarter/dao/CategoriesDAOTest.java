package nikfisher.kickstarter.dao;

public class CategoriesDAOTest extends CategoriesTest {

    @Override
    Categories getCategories() {
        return new CategoriesDAO();
    }
}