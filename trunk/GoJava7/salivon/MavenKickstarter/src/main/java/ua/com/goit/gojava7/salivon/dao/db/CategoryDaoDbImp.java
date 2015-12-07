package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.dao.CategoryDao;

public class CategoryDaoDbImp implements CategoryDao {

    DBUtil util = new DBUtil();

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        ResultSet res = null;
        String query = "SELECT IdCategory, Name FROM category ORDER BY IdCategory";
        util.openConnection();
        res = util.executeQuery(query);
        try {
            while (res.next()) {
                categories.add(new Category(res.getString("Name"), res.getInt("IdCategory")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        ResultSet res = null;
        String query = "SELECT Name FROM category WHERE IdCategory = " + idCategory;
        util.openConnection();
        res = util.executeQuery(query);
        try {
            res.next();
            requestedCategory = new Category(res.getString("Name"), idCategory);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return requestedCategory;
    }

}
