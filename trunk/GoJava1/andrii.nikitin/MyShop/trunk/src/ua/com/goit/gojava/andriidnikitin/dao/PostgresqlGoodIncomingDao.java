package ua.com.goit.gojava.andriidnikitin.dao;

import java.math.BigDecimal;
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
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodIncoming;

public class PostgresqlGoodIncomingDao implements GenericDao<GoodIncoming> {
	private Connection connection;

	private static Logger log = Logger.getLogger("MyShop.DAO");
	private static final String CLASSNAME = PostgresqlGoodIncomingDao.class.getCanonicalName();
	private static final String GOOD_INCOME_CLASSNAME = Good.class.getCanonicalName();
	
    public PostgresqlGoodIncomingDao(Connection connection) {
		   log.info("Created new instance of " + CLASSNAME + " using connection " + connection.toString());
        this.connection = connection;
    }

	@Override
	public Integer create(GoodIncoming arg) throws MyShopDaoException {
		String sql = "INSERT INTO \"GoodIncoming\"(good_id, quantity, price) VALUES ( ?, ?, ?) RETURNING income_id;";
	    PreparedStatement stm;
	    Integer incomeId;
		try {
			stm = connection.prepareStatement(sql);	
		    Good good = arg.getGood();	
		    stm.setInt(1, good.getId());
		    stm.setInt(2, arg.getAmount());
		    stm.setBigDecimal(3, arg.getPrice());
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    incomeId = rs.getInt("income_id");	
		    log.info("Created new instance of " + GOOD_INCOME_CLASSNAME + " by " 
		    		+ this.toString() + " with id " + incomeId);
		    return incomeId;
		} catch (SQLException e) {
			String errorSpot = "creating record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}	    
	}

	@Override
	public GoodIncoming read(Integer key) throws MyShopDaoException {
		GoodIncoming result = null;
		BigDecimal price = null;
		Integer goodId = null;
		Integer quantity = null;
		try {
		    String sql = "SELECT * FROM \"GoodIncoming\" WHERE income_id=?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    price = rs.getBigDecimal("price");
		    quantity = rs.getInt("quantity");
		    goodId = rs.getInt("good_id");
		    result = new GoodIncoming();
		    PostgresqlDaoFactory factory = PostgresqlDaoFactory.getInstance();
		    GenericDao<Good> dao = factory.getGoodDao(connection);
		    result.setGood(dao.read(goodId));
		    result.setAmount(quantity);
		    result.setPrice(price);
		    result.setId(key);	 
			} catch (SQLException e) {
				if ((goodId == null)  || (price == null)){	
					String errorSpot = "reading record of " + GOOD_INCOME_CLASSNAME + " object in DB ";
					ErrorLogger.logSQLException(e, errorSpot, log);
					throw new MyShopDaoException(e);		
				} 
			}		  
		    log.info("Retrieved new instance of " + GOOD_INCOME_CLASSNAME + " by " 
		    		+ this.toString() + " with id " + goodId);
	        return result;	
	}
		
	@Override
	public void update(GoodIncoming arg) throws MyShopDaoException {
		int key = arg.getId();
		try {
			Good good = arg.getGood();
			Integer goodId = good.getId();				
			Integer amount = arg.getAmount();			
			BigDecimal price = arg.getPrice();
			String sql;
			PreparedStatement stm;			
			sql = "UPDATE \"GoodIncomimg\" SET price=?, quantity=?,  good_id=? WHERE income_id = ?;";	
			stm = connection.prepareStatement(sql);
			stm.setBigDecimal(1, price);
			stm.setInt(2, amount);
			stm.setInt(2, goodId);
			stm.setInt(3, key);
		    stm.executeUpdate();	
	    } catch (SQLException e) {
	    	String errorSpot = "updating record of Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}
		log.info(GOOD_INCOME_CLASSNAME + " with id = " + key + " was succesfully updated");
	}

	@Override
	public void delete(GoodIncoming arg) throws MyShopDaoException {
		try {
			int key = arg.getId();
			String sql = "DELETE FROM \"GoodIncoming\" WHERE income_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeUpdate();		
	    } catch (SQLException e) {
	    	String errorSpot = "deleting record of " + GOOD_INCOME_CLASSNAME +
	    			" Good object in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}

	}

	@Override
	public List<GoodIncoming> getAll() throws MyShopDaoException {
		try {
	        String sql = "SELECT \"income_id\" FROM \"GoodIncoming\"";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        List<Integer> listInts = new ArrayList<Integer>();
	        List<GoodIncoming> list = new ArrayList<GoodIncoming>();
	        while (rs.next()) {
	            Integer typeId = rs.getInt("income_id");
	            listInts.add(typeId);
	        }
	        for (Integer id: listInts){
	            list.add(read(id));
	        }
	        return list;
        } catch (SQLException e) {
        	String errorSpot = "retrieving all records of " + GOOD_INCOME_CLASSNAME + ""
        			+ "objects in DB ";
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}
	}	
}
