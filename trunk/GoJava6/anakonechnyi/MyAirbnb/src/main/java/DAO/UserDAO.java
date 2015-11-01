package main.java.DAO;

import main.java.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by A_Nakonechnyi on 21.10.2015.
 */
public class UserDAO extends AbstractDAO {
    public void createUser (User user) {
        String sqlQuery = "INSERT INTO `airbnb`.`users` (`name`, `ser_name`, `email`, `is_host`) VALUES ('"+
                user.getName()+"`, `"+
                user.getSername()+"`, `"+
                user.getEmail()+"`, `";
        if (user.getIsHost()==true) {
            sqlQuery+="1`);";
        } else {
            sqlQuery+="0`);";
        }
        updateDB(sqlQuery);
    }

    public void updateUserByID (User user) {
        String sqlQuery = "UPDATE airbnb.users SET " +
                "name = '"+ user.getName()+
                "ser_name = '"+ user.getSername()+
                "email = '"+ user.getEmail()+
                "is_host = '"+user.getIsHost() +
                "WHERE user_id = "+ user.clientId;
        updateDB(sqlQuery);
    }

    public List<User> getUsers () {
        return (List<User>)(List<?>)readDB("SELECT * FROM users");
    }

    public void deleteUserByID (User user) {
        String sqlQuery = "DELETE FROM users WHERE user_id = "+user.clientId;
        updateDB(sqlQuery);
    }

    public User getUserByID (User user) {
        String sqlQuery = "SELECT * FROM users WHERE user_id =" + user.clientId;
        List<User> userList = (List<User>)(List<?>) readDB(sqlQuery);
        return userList.get(0);
    }

    @Override
    User readObj(ResultSet resultSet) throws SQLException {
        User result = new User(resultSet.getInt("user_id"),
                               resultSet.getString("name"),
                               resultSet.getString("ser_name"),
                               resultSet.getString("email"),
                               resultSet.getBoolean("is_host") );
        return result;
    }
}
