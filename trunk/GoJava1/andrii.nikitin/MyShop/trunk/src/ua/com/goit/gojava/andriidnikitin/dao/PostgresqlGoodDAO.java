package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.util.ErrorLogger;

public class PostgresqlGoodDAO implements GenericDAO<Good> {
	private Connection connection;

	private static Logger log = Logger.getLogger("MyShop.DAO");
	
    public PostgresqlGoodDAO(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Integer create(Good arg) throws MyShopDAOException {
		String sql = "INSERT INTO \"Good\"(name, type_id) VALUES ( ?, ?) RETURNING good_id;";
	    PreparedStatement stm;
	    Integer typeId;
		try {
			stm = connection.prepareStatement(sql);		
		    stm.setString(1, arg.getName());
		    GoodType parent = arg.getType();
		    stm.setInt(2, parent.getId());
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    typeId = rs.getInt("good_id");	
		    return typeId;
		} catch (SQLException e) {
			String errorSpot = "creating record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDAOException(e);
		}	    
	}

	@Override
	public Good read(Integer key) throws MyShopDAOException {
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
		        	typeId = null;
		        }
		        result = new Good();
		        result.setId(goodId);
		        result.setName(name);
		        PostgresqlDAOFactory factory = PostgresqlDAOFactory.getInstance();
		        GenericDAO<GoodType> dao = factory.getGoodTypeDAO(connection);
		        result.setType(dao.read(typeId));	 
			} catch (SQLException e) {
				if ((goodId == null)  || (name == null)){	
					String errorSpot = "reading record of Good object in DB ";
					ErrorLogger.logSQLException(e, errorSpot, log);
					throw new MyShopDAOException(e);		
				} 
			}		       
	        return result;	
	}
		
	@Override
	public void update(Good unit) throws MyShopDAOException {
		try {
			int key = unit.getId();
			GoodType type = unit.getType();
			Integer parentKey = type.getId();				
			String name = unit.getName();
			String sql;
			PreparedStatement stm;
			if (parentKey!= null){
				sql = "UPDATE \"Good\" SET name=?, type_id=? WHERE good_id = ?;";	
			    stm = connection.prepareStatement(sql);
			    stm.setString(1, name);
			    stm.setInt(2, parentKey);
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
			throw new MyShopDAOException(e);
		}

	}

	@Override
	public void delete(Good unit) throws MyShopDAOException {
		try {
			int key = unit.getId();
			String sql = "DELETE FROM \"Good\" WHERE good_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeUpdate();		
	    } catch (SQLException e) {
	    	String errorSpot = "deleting record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDAOException(e);
		}

	}

	@Override
	public List<Good> getAll() throws MyShopDAOException {
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
			throw new MyShopDAOException(e);
		}
	}	
}
