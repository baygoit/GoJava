package goit.vh.kickstarter.dao;

/**
 * Created by Viktor on 01.08.2015.
 */
public class FileDAOFactory extends DAOFactory {
    @Override
    public CategoryDAO getCategoryDAO() {
        return null;
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return null;
    }
}
