package goit.vh.kickstarter.dao;

        import goit.vh.kickstarter.Output;
        import goit.vh.kickstarter.mvc.model.CategoryModel;
        import goit.vh.kickstarter.mvc.model.ProjectModel;

        import java.sql.*;
        import java.util.*;

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


    @Override
    public Map<Integer, ArrayList<ProjectModel>> getCategories() {
        //  String sql = "SELECT DISTINCT parentname,parentid FROM project ORDER BY parentname,parentid";
        String sql = "SELECT * FROM project ORDER BY parentid";
        Map<Integer, ArrayList<ProjectModel>> categories = new HashMap<>();
        ArrayList<ProjectModel> category = new ArrayList<>();;
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            int categoryID = 1;
            while (rs.next()) {

                if (rs.getInt("parentid") != categoryID) {
                    categories.put(categoryID, category);
                    category = new ArrayList<>();
                    categoryID = rs.getInt("parentid");
                }
                category.add(new ProjectModel(rs.getString("name"), rs.getString("shortdescription"),
                        rs.getInt("sumtoraise"), rs.getInt("currentsum"), rs.getDate("enddate"),
                        rs.getString("projecthistory"), rs.getString("faq"), rs.getString("demourl"),
                        rs.getString("parentname"), rs.getInt("parentid")));
                categories.put(categoryID, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TODO How automatically close connection?
        try {
            if (connection.isClosed()){
                new Output().println("Connection is closed");
            }
            else {
                connection.close();
                new Output().println("Connection was not closed! Closing connection...");
            }
        } catch (SQLException t) {
            t.printStackTrace();
        }
        return categories;
    }

    @Override
    public void registerCategories(Map<Integer, ArrayList<ProjectModel>> categories) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);
        String sql = "INSERT INTO project (id, name, shortdescription, sumtoraise," +
                "currentsum, enddate, projecthistory,faq, demourl,parentname,parentid)" +
                "VALUES " +
                "(1,'Gluconazol -', 'Brend new anabolics;', 25000000, 7500000, '2019-09-25'," +
                " 'New MOC politics dictetes new requirements for pharmasy;'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Sport', 1)," +
                "(2,'Warriors of eternity -', 'New game, clone of ''Game of thrones'';', 10000, 1500, '2019-09-25'," +
        " 'Game of thrones was a very good game, but it starts to bore people, so new game is on!!;'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Table games', 2)";


        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();

        }
       //TODO where we must close connection?

    }

    @Override
    public CategoryModel getCategoryByID(int id) {
        return null;
    }
}
