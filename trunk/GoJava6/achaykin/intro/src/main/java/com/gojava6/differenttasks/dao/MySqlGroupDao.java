package com.gojava6.differenttasks.dao;

import com.gojava6.differenttasks.dao.domain.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public class MySqlGroupDao implements GroupDAO {

    private final Connection connection;

    public Group create(Group group) throws SQLException {
        String query = "INSERT INTO daotalk.Group VALUES (?, ?, ?);";

        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setInt(1, group.getId());
        pstm.setInt(2, group.getNumber());
        pstm.setString(3, group.getDepartment());
        return null;
    }

    public Group read(int key) throws SQLException {
        String query = "SELECT * FROM daotalk.Group WHERE id = ?;";
        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setInt(1, key);

        ResultSet rs = pstm.executeQuery();

        rs.next();

        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setNumber(rs.getInt("number"));
        group.setDepartment(rs.getString("department"));

        return group;
    }

    public void update(Group group) {
        String query = "UPDATE daotalk.Group SET number = ?, department = ? WHERE id = ?;";

        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, group.getNumber());
            pstm.setString(2, group.getDepartment());
            pstm.setInt(3, group.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Group group) {
        String query = "DELETE FROM daotalk.Group WHERE id = ?;";
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, group.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Group> getAll() throws SQLException {
        String query = "SELECT * FROM daotalk.Group;";
        PreparedStatement pstm = connection.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        List<Group> list = new ArrayList<Group>();

        while (rs.next()) {
            Group group = new Group();
            group.setId(rs.getInt("id"));
            group.setNumber(rs.getInt("number"));
            group.setDepartment(rs.getString("department"));
            list.add(group);
        }

        return list;
    }

    public MySqlGroupDao(Connection connection) {
        this.connection = connection;
    }
}
