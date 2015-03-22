package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.DaoFactory;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.GenericDao;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.PostgresqlDaoFactory;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;



public class GoodCatalogImpl implements GoodCatalog{	

	private static Logger log = Logger.getLogger("MyShop.BL");
	
	private static GoodCatalogImpl instance = null;

	public static GoodCatalogImpl getInstance() {
		if (instance == null) {
			instance = new GoodCatalogImpl();
		}
		return instance;
	}

	public GoodType createType(String name, Integer parentId) throws MyShopException {
	    DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao(con);
		        GoodType type = new GoodType();
		        GoodType parent = null;
		        if (parentId!= null){
		        	parent = dao.read(parentId);
		        }
				type.setParent(parent);
		        type.setName(name);
		        Integer id = dao.create(type);
		        type.setId(id);
		        return type;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
			 throw new MyShopException (e);		 
		 }		 
	}

	public GoodType getGoodTypeById(Integer id) throws MyShopException{
	    DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao(con);
		        GoodType type = dao.read(id);
		        return type;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }		 
	}

	public void deleteGoodType(Integer id) throws MyShopException {
	    DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao(con);
		        GoodType type = dao.read(id);
		        dao.delete(type);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }			
	}

	public List<GoodType> getAllTypes() throws MyShopException {
	    DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao(con);
		        List<GoodType> list = dao.getAll();
		        return list;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }	
	}

	public GoodType updateGoodType(Integer id, String name, Integer parentId) throws MyShopException{
	    DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao(con);
		        GoodType type = new GoodType();
		        GoodType parent = null;
		        if (parentId!= null){
		        	parent = dao.read(parentId);
		        }
				type.setParent(parent);
		        type.setName(name);
		        type.setId(id);
		        dao.update(type);
		        return dao.read(id);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }	
	}

	public Good createGood(String name, Integer typeId) throws MyShopException {
		 DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<Good> dao = daoFactory.getGoodDao(con);
		        GenericDao<GoodType> daoType = daoFactory.getGoodTypeDao(con);
		        Good good = new Good();
		        GoodType type = null;
		        if (typeId!= null){
		        	type = daoType.read(typeId);
		        }
				good.setType(type);
		        good.setName(name);
		        Integer id = dao.create(good);
		        good.setId(id);
		        return good;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }	
	}

	public Good getGoodById(Integer id) throws MyShopException{
		DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<Good> dao = daoFactory.getGoodDao(con);
		        Good good = dao.read(id);
		        return good;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }	
	}

	public Good updateGood(Integer id, String name, Integer typeId) throws MyShopException{
		DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<Good> dao = daoFactory.getGoodDao(con);
		        GenericDao<GoodType> daoType = daoFactory.getGoodTypeDao(con);
		        Good good = new Good();
		        GoodType type = null;
		        if (typeId!= null){
		        	type = daoType.read(typeId);
		        }
				good.setType(type);
		        good.setName(name);
		        good.setId(id);
		        dao.update(good);
		        return dao.read(id);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }	
	}

	public void deleteGood(Integer id) throws MyShopException {
		 DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<Good> dao = daoFactory.getGoodDao(con);
		        Good good = dao.read(id);
		        dao.delete(good);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }
		
	}

	public List<Good> getAllGoods() throws MyShopException {
		DaoFactory daoFactory = PostgresqlDaoFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDao<Good> dao = daoFactory.getGoodDao(con);
		        List<Good> list = dao.getAll();
		        return list;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new MyShopException (e);		 
		 }	
	}

	
}
