package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.DaoFactory;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.GenericDao;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.GenericExtraDao;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

@Service
public class GoodCatalogImpl implements GoodCatalog{	
	
	private DaoFactory daoFactory;
	
	private Logger log;

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	public void setLog(Logger log) {
		this.log = log;
	}
	
	public GoodType createType(String name, Integer parentId) throws MyShopException {
		 try {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao();
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
		 }
	}

	public GoodType getGoodTypeById(Integer id) throws MyShopException{
		 try {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao();
		        GoodType type = dao.read(id);
		        return type;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 }	 
	}

	public void deleteGoodType(Integer id) throws MyShopException {
		 try {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao();
		        GoodType type = dao.read(id);
		        dao.delete(type);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } 		
	}

	public List<GoodType> getAllTypes() throws MyShopException {
		 try {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao();
		        List<GoodType> list = dao.getAll();
		        return list;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } 	
	}

	public GoodType updateGoodType(Integer id, String name, Integer parentId) throws MyShopException{
		 try {
		        GenericDao<GoodType> dao = daoFactory.getGoodTypeDao();
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
		 } 
	}

	public Good createGood(String name, Integer typeId) throws MyShopException {
		 try {
		        GenericDao<Good> dao = daoFactory.getGoodDao();
		        Good good = new Good();		 
		        GoodType type = daoFactory.getGoodTypeDao().read(typeId);
				good.setType(type);
		        good.setName(name);
		        Integer id = dao.create(good);
		        good.setId(id);
		        return good;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } 
	}

	public Good getGoodById(Integer id) throws MyShopException{
		 try {
		        GenericDao<Good> dao = daoFactory.getGoodDao();
		        Good good = dao.read(id);
		        return good;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } 
	}

	public Good updateGood(Integer id, String name, Integer typeId) throws MyShopException{
		 try {
		        GenericDao<Good> dao = daoFactory.getGoodDao();
		        Good good = new Good();
				good.setType(daoFactory.getGoodTypeDao().read(typeId));
		        good.setName(name);
		        good.setId(id);
		        dao.update(good);
		        return dao.read(id);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } 
	}

	public void deleteGood(Integer id) throws MyShopException {
		 try {
		        GenericDao<Good> dao = daoFactory.getGoodDao();
		        Good good = dao.read(id);
		        dao.delete(good);
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);
		 } 
		
	}

	public List<Good> getAllGoods() throws MyShopException {
		try {
			GenericDao<Good> dao = daoFactory.getGoodDao();
		    if (dao==null){
		    	log.warn("dao is null");
		    }
		    List<Good> list = dao.getAll();
		    return list;
		 } catch(MyShopDaoException e){
			 throw new MyShopException (e);		
		 }
	}

	@Override
	public List<Good> getGoodsFilteringByName(String query) throws MyShopException {	
		GenericExtraDao<Good> dao;
		List<Good> result;
		try {
			dao = daoFactory.getGoodDaoExtended();
			result =  dao.getFilteringByName(query);
		} catch (MyShopDaoException e) {
			throw new MyShopException(e);
		}	
		return result;
	}

	@Override
	public List<GoodType> getGoodTypesFilteringByName(String query)
			throws MyShopException {
		GenericExtraDao<GoodType> dao;
		List<GoodType> result;
		try {
			dao = daoFactory.getGoodTypeExtraDao();
			result =  dao.getFilteringByName(query);
		} catch (MyShopDaoException e) {
			throw new MyShopException(e);
		}	
		return result;
	}

	@Override
	public List<GoodType> getGoodTypesByName(String name) throws MyShopException {
		List<GoodType> result;
		try {
			GenericExtraDao<GoodType> dao = daoFactory.getGoodTypeExtraDao();
			result =  dao.getFilteringByName(name);
		} catch (MyShopDaoException e) {
			throw new MyShopException(e);
		}
		return result;
	}
	
}
