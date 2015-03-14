/**
 * 
 */
package ua.com.goit.alexkholmov.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ua.goit.alexkholmov.dao.DAOFactory;
import com.ua.goit.alexkholmov.logic.Contact;
import com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact;
import com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoFactory;

/**
 * @author SASH
 *
 */
public class TestDaoContact {

    /**
     * Test method for {@link com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact#PostgreSQLDaoContact(java.sql.Connection)}.
     */
    @Test
    public void testPostgreSQLDaoContact() {
        //fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact#create()}.
     */
    @Test
    public void testCreate() {
        //fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact#read(int)}.
     */
    @Test
    public void testRead() {
        //fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact#update(com.ua.goit.alexkholmov.logic.Contact)}.
     */
    @Test
    public void testUpdate() {
        //fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact#delete(com.ua.goit.alexkholmov.logic.Contact)}.
     */
    @Test
    public void testDelete() {
        //fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoContact#getAll()}.
     * @throws Exception 
     */
    @Test
    public void testGetAll() throws Exception {
        List<Contact> list;
        Connection con = null;
        DAOFactory daoFactory = new PostgreSQLDaoFactory();
        try {
            con = daoFactory.getConnection();  
            PostgreSQLDaoContact daoContact = (PostgreSQLDaoContact) daoFactory.getContactDao(con);
            list = daoContact.getAll();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

}
