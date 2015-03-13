package ua.com.goit.gojava.andriidnikitin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.dao.DAOFactory;
import ua.com.goit.gojava.andriidnikitin.dao.GenericDAO;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlDAOFactory;
import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;
import ua.com.goit.gojava.andriidnikitin.util.ErrorLogger;


public class GoodCatalogImpl {	

	private static Logger log = Logger.getLogger("MyShop.BL");
	
	private static GoodCatalogImpl instance = null;

	public static GoodCatalogImpl getInstance() {
		if (instance == null) {
			instance = new GoodCatalogImpl();
		}
		return instance;
	}

	public GoodType createType(String name, Integer parentId) throws ShopException {
	    DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
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
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
			 throw new ShopException (e);		 
		 }		 
	}

	public GoodType getGoodTypeById(Integer id) throws ShopException{
	    DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
		        GoodType type = dao.read(id);
		        return type;
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }		 
	}

	public void deleteGoodType(Integer id) throws ShopException {
	    DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
		        GoodType type = dao.read(id);
		        dao.delete(type);
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }			
	}

	public List<GoodType> getAllTypes() throws ShopException {
	    DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
		        List<GoodType> list = dao.getAll();
		        return list;
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }	
	}

	public GoodType updateGoodType(Integer id, String name, Integer parentId) throws ShopException{
	    DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
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
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }	
	}

	public Good createGood(String name, Integer typeId) throws ShopException {
		 DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<Good> dao = daoFactory.getGoodDAO(con);
		        GenericDAO<GoodType> daoType = daoFactory.getGoodTypeDAO(con);
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
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }	
	}

	public Good getGoodById(Integer id) throws ShopException{
		DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<Good> dao = daoFactory.getGoodDAO(con);
		        Good good = dao.read(id);
		        return good;
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }	
	}

	public Good updateGood(Integer id, String name, Integer typeId) throws ShopException{
		DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<Good> dao = daoFactory.getGoodDAO(con);
		        GenericDAO<GoodType> daoType = daoFactory.getGoodTypeDAO(con);
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
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }	
	}

	public void deleteGood(Integer id) throws ShopException {
		 DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<Good> dao = daoFactory.getGoodDAO(con);
		        Good good = dao.read(id);
		        dao.delete(good);
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }
		
	}

	public List<Good> getAllGoods() throws ShopException {
		DAOFactory daoFactory = PostgresqlDAOFactory.getInstance();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<Good> dao = daoFactory.getGoodDAO(con);
		        List<Good> list = dao.getAll();
		        return list;
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
				String errorSpot = "getting connection to DB via DAOFactory";
				ErrorLogger.logSQLException(e, errorSpot, log);
			 throw new ShopException (e);		 
		 }	
	}

	
}
