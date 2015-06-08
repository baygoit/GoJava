package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.jdbc.DAOFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Created by koros on 08.06.2015.
 */
public class MySQLQuoteDAOTest {

    @Test
    public void testGetAll() throws Exception {
        DAOFactory daoFactory = new MySQLDaoFactory();
        List<Quote> list;
        try (Connection connection = daoFactory.getConnection()) {
            DAO<Quote> dao = daoFactory.getQuoteDao(connection);
            list = dao.getAll();
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }
}