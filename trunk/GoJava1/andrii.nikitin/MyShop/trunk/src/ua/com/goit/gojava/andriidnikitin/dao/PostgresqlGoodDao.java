package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodType;

public class PostgresqlGoodDao implements GenericDao<Good> {
	private Connection connection;

	private static Logger log = Logger.getLogger("MyShop.DAO");
	private static final String CLASSNAME = PostgresqlGoodDao.class.getCanonicalName();
	private static final String GOOD_CLASSNAME = Good.class.getCanonicalName();
	
    public PostgresqlGoodDao(Connection connection) {
		   log.info("Created new instance of " + CLASSNAME + " using connection " + connection.toString());
        this.connection = connection;
    }

	@Override
	public Integer create(Good arg) throws MyShopDaoException {
		String sql = "INSERT INTO \"Good\"(name, type_id) VALUES ( ?, ?) RETURNING good_id;";
	    PreparedStatement stm;
	    Integer goodId;
		try {
			stm = connection.prepareStatement(sql);		
		    stm.setString(1, arg.getName());
		    GoodType parent = arg.getType();
		    stm.setInt(2, parent.getId());
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    goodId = rs.getInt("good_id");	
		    log.info("Created new instance of " + GOOD_CLASSNAME + " by " 
		    		+ this.toString() + " with id " + goodId);
		    return goodId;
		} catch (SQLException e) {
			String errorSpot = "creating record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}	    
	}

	@Override
	public Good read(Integer key) throws MyShopDaoException {
		 Good result = null;
			String name = null;
		    Integer goodId = null;
		    Integer typeId = null;
			try {
		        String sql = "SELECT * FROM \"Good\" WHERE good_id=?;";
		        PreparedStatement stm = connection.prepareStatement(sql);
		        stm.setInt(1, key);
		        ResultSet rs = stm.executeQuery();
		        rs.next();
		        name = rs.getString("name");
		        goodId = rs.getInt("good_id");
		        try { 
		        	typeId = rs.getInt("type_id");
		        } catch (Exception e){
		        	log.warn("type of Good with id = " + key + " is null");
		        	typeId = null;
		        }
		        result = new Good();
		        result.setId(goodId);
		        result.setName(name);
		        PostgresqlDaoFactory factory = PostgresqlDaoFactory.getInstance();
		        GenericDao<GoodType> dao = factory.getGoodTypeDao(connection);
		        result.setType(dao.read(typeId));	 
			} catch (SQLException e) {
				if ((goodId == null)  || (name == null)){	
					String errorSpot = "reading record of Good object in DB ";
					ErrorLogger.logSQLException(e, errorSpot, log);
					throw new MyShopDaoException(e);		
				} 
			}		  

		    log.info("Retrieved new instance of " + GOOD_CLASSNAME + " by " 
		    		+ this.toString() + " with id " + goodId);
	        return result;	
	}
		
	@Override
	public void update(Good unit) throws MyShopDaoException {
		int key = unit.getId();
		try {
			GoodType type = unit.getType();
			Integer typeId = type.getId();				
			String name = unit.getName();
			String sql;
			PreparedStatement stm;
			if (typeId!= null){
				sql = "UPDATE \"Good\" SET name=?, type_id=? WHERE good_id = ?;";	
			    stm = connection.prepareStatement(sql);
			    stm.setString(1, name);
			    stm.setInt(2, typeId);
			    stm.setInt(3, key);
			}
			else {
				sql = "UPDATE \"Good\" SET name=? WHERE good_id = ?;";		
			    stm = connection.prepareStatement(sql);
			    stm.setString(1, name);
			    stm.setInt(2, key);	
			}
		    stm.executeUpdate();	
	    } catch (SQLException e) {
	    	String errorSpot = "updating record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}
		log.info(GOOD_CLASSNAME + " with id = " + key + " was succesfully updated");

	}

	@Override
	public void delete(Good unit) throws MyShopDaoException {
		try {
			int key = unit.getId();
			String sql = "DELETE FROM \"Good\" WHERE good_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeUpdate();		
	    } catch (SQLException e) {
	    	String errorSpot = "deleting record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}

	}

	@Override
	public List<Good> getAll() throws MyShopDaoException {
		try {
	        String sql = "SELECT \"good_id\" FROM \"Good\"";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        List<Integer> listInts = new ArrayList<Integer>();
	        List<Good> list = new ArrayList<Good>();
	        while (rs.next()) {
	            Integer typeId = rs.getInt("good_id");
	            listInts.add(typeId);
	        }
	        for (Integer id: listInts){
	            list.add(read(id));
	        }
	        return list;
        } catch (SQLException e) {
        	String errorSpot = "retrieving all records of Good objects in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}
	}	
}
