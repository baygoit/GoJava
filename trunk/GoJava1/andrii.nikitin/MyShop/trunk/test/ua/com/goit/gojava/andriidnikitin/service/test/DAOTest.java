package ua.com.goit.gojava.andriidnikitin.service.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.dao.CatalogDaoFactory;
import ua.com.goit.gojava.andriidnikitin.dao.GenericDao;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlDaoFactory;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;


public class DAOTest {
	
	@Test
	public void testGetAll() throws Exception {
	    CatalogDaoFactory<GoodType> daoFactory = new PostgresqlDaoFactory<GoodType>();
	    List<GoodType> list;
	    GenericDao<GoodType> dao;
	    try (Connection connection = daoFactory.getConnection()) {
	        dao = daoFactory.getGoodTypeDao(connection);
	        list = dao.getAll();
	        assertNotNull(list);
		    assertTrue(list.size() > 0);
		    for (GoodType type: list){
		    	System.out.println(type.getName() +  "  "+ type.getId() +"  "+  type.getParent());
		    }
		    GoodType type = new GoodType();
		    type.setParent(list.get(1));
		    type.setName("Electro guitars");
		    type = dao.create(type);
		    dao.getAll();
		    for (GoodType tempType: list){
		    	if (tempType.getName().equals("Electro guitars")){
		    		dao.delete(tempType);
		    	}
		    	
		    }
		    System.out.println("Brand new    " + type.getName() +  "  "+ type.getId() +"  "+  type.getParent());
	    }
	    
	}
}
