package ua.com.scread.kickstarter.dao;
//package ua.com.scread.kickstarter.storage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import ua.com.scread.kickstarter.data.Category;
//import ua.com.scread.kickstarter.data.Project;
//
////public class ProjectsDAO implements Projects {
//
//    @Override
//    public int size() {
//        int size = 0;
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet rs = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            try {
//                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            statement = connection.createStatement();
//            rs = statement.executeQuery("SELECT * FROM categories");
//            while (rs.next()) {
//                size++;
//            }
//            return size;
//        } catch (Exception e) {
//            throw new RuntimeException("Something happent while calculation Projects size!", e);
//        } finally {
//            try {
//                rs.close();
//                statement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException("Something happent while closing connection!", e);
//            }
//        }
//    }
//
//    @Override
//    public List<Project> getProjects() {
//        List<Project> result = new ArrayList<Project>();
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet rs = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            try {
//                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            statement = connection.createStatement();
//            rs = statement.executeQuery("SELECT * FROM categories");
//            while (rs.next()) {
//                //result.add(new Project(rs.getString(2)));
//            }
//            return result;
//        } catch (Exception e) {
//            throw new RuntimeException("Something happent while getting all Projects!", e);
//        } finally {
//            try {
//                rs.close();
//                statement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException("Something happent while closing connection!", e);
//            }
//        }
//    }
//
////    @Override
////    public List<Project> getProjects(Category category) {
////        List<Project> projects = new ArrayList<Project>();
////        Connection connection = null;
////        Statement statement = null;
////        ResultSet rs = null;
////        try {
////            Class.forName("org.postgresql.Driver");
////            try {
////                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////            statement = connection.createStatement();
////            rs = statement.executeQuery("SELECT * FROM projects");
////            while (rs.next()) {
//////                if (rs.getInt(1) == (index + 1)) {
//////                    projects.add(new Project(rs.getString(2));
////                    break;
////                } else {
////                    // do nothing
////                }
////            }
////            return projects;
////        } catch (Exception e) {
////            throw new RuntimeException("Something happent while getting Progects by Category!", e);
////        } finally {
////            try {
////                rs.close();
////                statement.close();
////                connection.close();
////            } catch (SQLException e) {
////                throw new RuntimeException("Something happent while closing connection!", e);
////            }
////        }
////    }
//
//    @Override
//    public void add(Project project) {
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            try {
//                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            statement = connection.createStatement();
//            PreparedStatement ps = connection.prepareStatement("INSERT INTO projects (name) values (?)");
//            ps.setString(1, project.getName());
//            ps.execute();
//        } catch (Exception e) {
//            throw new RuntimeException("Something happent while adding Project!", e);
//        } finally {
//            try {
//                statement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException("Something happent while closing connection!", e);
//            }
//        }
//        
//    }
//}
