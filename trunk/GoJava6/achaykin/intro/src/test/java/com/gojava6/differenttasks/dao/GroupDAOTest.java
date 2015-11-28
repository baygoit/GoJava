package com.gojava6.differenttasks.dao;

import com.gojava6.differenttasks.dao.domain.Group;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GroupDAOTest {


    @Test
    public void getAllTest() {
        DAOFactory daoFactory = new MySqlDaoFactory();
        List<Group> list = null;
        Connection connection = null;
        try {
            connection = daoFactory.getConnection();
            GroupDAO dao = daoFactory.getGroupDAO(connection);
            list = dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }

        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

}
