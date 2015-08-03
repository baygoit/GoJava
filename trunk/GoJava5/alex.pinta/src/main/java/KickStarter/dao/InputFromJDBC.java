package java.KickStarter.dao;

import java.KickStarter.model.Category;
import java.KickStarter.model.Project;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.DataSourceConnectionFactory;
import org.apache.commons.dbcp2.managed.BasicManagedDataSource;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 31.07.15
 * Time: 15:58
 * @version: 1.0
 */
public class InputFromJDBC implements LoadingData {


    public static DataSourceConnectionFactory dataSourceConnectionFactory;

    public InputFromJDBC(String url, String user, String password) {
        if (dataSourceConnectionFactory == null){
            BasicDataSource ds = new BasicManagedDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl(url);    //"//localhost/KickStarter"
            ds.setUsername(user);  //postgres
            ds.setPassword(password);
            ds.setDefaultAutoCommit(false);
            dataSourceConnectionFactory = new DataSourceConnectionFactory(ds);
        }
    }

    @Override
    public void load() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<Category, ArrayList<Project>> getMapping() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArrayList<Category> getCategoryList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveData() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
