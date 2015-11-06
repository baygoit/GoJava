package com.azuiev.dao;
import com.azuiev.db.AirbnbDBDao;
import com.azuiev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 08.10.15.
 */
public class UserDao implements ModelDao {

    private final Connection connection;


    public UserDao(Connection connection) {
        this.connection = connection;
    }
    public UserDao() {
        connection = new AirbnbDBDao().getConnection();

    }
    @Override
    public List<User> getAll() throws SQLException {
        String sql = "select * from user;";
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        User user = null;
        List<User> list = new ArrayList<User>();


            while (rs.next()){
                User.Builder builder = User.createBuilder();
                user = builder.createUser(rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(user);
            }


        return list;
    }

    @Override
    public User getById(Long id) throws SQLException {

        String sql = "select * from user where id = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        User user = null;

            while (rs.next()){
                User.Builder builder = User.createBuilder();
                user = builder.createUser(rs.getString(2), rs.getString(3), rs.getString(4));

            }

        return user;

    }

    public User login(String email, String password) throws SQLException {
        String sql = "select id, name, surname, email  from user where email = ? and password = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();

        User user = null;

        while (rs.next()){
            User.Builder builder = User.createBuilder();
            user = builder.createUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

        }

        return user;
    }

    @Override
    public void update(Object obj) {
        //TODO
    }

    @Override
    public void add(Object obj) {
        //TODO
    }


    @Override
    public void delete(Object obj) {
        //TODO
    }
}
