package ua.com.goit.gojava.andriidnikitin.servlets;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.dao.DAOFactory;
import ua.com.goit.gojava.andriidnikitin.dao.GenericDAO;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlDAOFactory;
import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;


public class GoodCatalogImpl {
	
	private static GoodCatalogImpl instance = null;

	public static GoodCatalogImpl getInstance() {
		if (instance == null) {
			instance = new GoodCatalogImpl();
		}
		return instance;
	}

	public GoodType createType(String name, Integer parentId) throws ShopException {
	    DAOFactory daoFactory = new PostgresqlDAOFactory();
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
		DAOFactory daoFactory = new PostgresqlDAOFactory();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
		        GoodType type = dao.read(id);
		        return type;
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
			 throw new ShopException (e);		 
		 }		 
	}

	public void deleteGoodType(Integer id) throws ShopException {
		DAOFactory daoFactory = new PostgresqlDAOFactory();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
		        GoodType type = dao.read(id);
		        dao.delete(type);
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
			 throw new ShopException (e);		 
		 }			
	}

	public List<GoodType> getAll() throws ShopException {
		DAOFactory daoFactory = new PostgresqlDAOFactory();
		 try (Connection con = daoFactory.getConnection()) {
		        GenericDAO<GoodType> dao = daoFactory.getGoodTypeDAO(con);
		        List<GoodType> list = dao.getAll();
		        return list;
		 } catch(MyShopDAOException e){
			 throw new ShopException (e);
		 } catch(SQLException e){
			 throw new ShopException (e);		 
		 }	
	}

	public GoodType updateGoodType(Integer id, String name, Integer parentId) throws ShopException{
		DAOFactory daoFactory = new PostgresqlDAOFactory();
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
			 throw new ShopException (e);		 
		 }	
	}

	
}
