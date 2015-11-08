package goit.vh.kickstarter.dao;

/**
 * Created by Viktor on 01.08.2015.
 */
public class InMemoryDAOFactory extends DAOFactory {
    @Override
    public CategoryDAO getCategoryDAO() {
        return  new CategoryInMemoryDAO();
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return null;
    }
}
