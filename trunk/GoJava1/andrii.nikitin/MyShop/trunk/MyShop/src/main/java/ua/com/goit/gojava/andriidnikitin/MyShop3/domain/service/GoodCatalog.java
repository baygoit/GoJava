package ua.com.goit.gojava.andriidnikitin.MyShop3.domain.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.util.MyShopException;


public interface GoodCatalog {
	
		public GoodType createType(String name, Integer parentId) throws MyShopException;
		
		public GoodType getGoodTypeById(Integer id) throws MyShopException;
		
		public void deleteGoodType(Integer id) throws MyShopException;
		
		public List<GoodType> getAllTypes() throws MyShopException;
		
		public GoodType updateGoodType(Integer id, String name, 
				Integer parentId) throws MyShopException;
		
		public Good createGood(String name, Integer typeId) throws MyShopException;
		
		public Good getGoodById(Integer id) throws MyShopException;
		
		public Good updateGood(Integer id, String name, 
				Integer typeId) throws MyShopException;
		
		public void deleteGood(Integer id) throws MyShopException;	
		
		public List<Good> getAllGoods() throws MyShopException;			
	}
