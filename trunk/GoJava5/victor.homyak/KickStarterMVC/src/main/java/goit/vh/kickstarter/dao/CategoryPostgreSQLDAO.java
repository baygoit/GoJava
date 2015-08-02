package goit.vh.kickstarter.dao;

import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Viktor on 01.08.2015.
 */
public class CategoryPostgreSQLDAO implements CategoryDAO {

    private final Connection connection;

    public CategoryPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

//    @Override
//    public Map<Integer, String> getCategories() {
//        String sql = "SELECT * FROM categoies ";
//
//        Map<Integer, String> categories = new HashMap<>();
//        try (PreparedStatement stm = connection.prepareStatement(sql)) {
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                categories.put(rs.getInt("id"), rs.getString("id"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return categories;
//
//
//    }

    @Override
    public Map<Integer, ArrayList<ProjectModel>> getCategories() {
        return null;
    }

    @Override
    public CategoryModel getCategoryByID(int id) {
        return null;
    }
}
