package com.azuiev.dao;
import com.azuiev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 08.10.15.
 */
public class DaoUser {

    private final Connection connection;

    public DaoUser(Connection connection) {
        this.connection = connection;
    }

    public User getById(Integer id) throws SQLException {
        //TODO
        String sql = "select * from user where id = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        User user = null;

        try {
            while (rs.next()){
                User.Builder builder = User.createBuilder();
                user = builder.createUser(rs.getString(2), rs.getString(3), rs.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    public void create() {
        return;
    }
}
