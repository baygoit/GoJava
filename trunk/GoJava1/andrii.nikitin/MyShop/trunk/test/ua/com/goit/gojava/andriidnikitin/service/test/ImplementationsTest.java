package ua.com.goit.gojava.andriidnikitin.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;
import ua.com.goit.gojava.andriidnikitin.service.GoodSuppliesImpl;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;


public class ImplementationsTest {
	
	@Test
	public void getGoodTypesTest() {/*
		final GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
		final List<GoodType> list = catalog.getGoodTypesFromRoot();
		assertNotNull(list);
		GoodType type = new GoodType();
		assertNotNull(catalog.getGoodsInType(type));
		assertNotNull(catalog.getGoodsInType(null));
		
		GoodType existingRootType = catalog.getGoodTypesFromRoot().get(0);
		assertTrue(catalog.isRoot(existingRootType));
		
		GoodType typeNotFromCatalogWithNullParent = type;
		assertFalse(catalog.isRoot(typeNotFromCatalogWithNullParent));
		
		Good someExistingGood = catalog.getAllGoods().get(0);//TODO - choose - delete this block or not
		GoodType typeOfGood = someExistingGood.getType();
		List<Good> listOfGoodsInThisType = catalog.getGoodsInType(typeOfGood);
		assertTrue(listOfGoodsInThisType.contains(someExistingGood));*/
		}
	
	@Test
	public void getFromFileTest(){
		final GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
		final String illegalFilename = "default#*/unexi...sting_filepath@&%^";//such file does not exist!
		try {
			catalog.initFromFile(null);
			fail();
		} catch (ShopException e) {
		}
		try {
			catalog.initFromFile(illegalFilename);
			fail();
		} catch (ShopException e) {
		}
	}
	
	@Test
	public void goodSuppliesImplTest(){
		final GoodSuppliesImpl instance = GoodSuppliesImpl.getInstance();
		assertNotNull(instance);
	}
	
	@Test
	public void getGoodTypesFromRootTest() {
		/*Object o = GoodCatalogImpl.getInstance().getGoodTypesFromRoot();
		@SuppressWarnings("unchecked")
		List<GoodType> list = (List<GoodType>) o;
		try{
			for (GoodType type: list) {
				type.getName();
			}
		} catch (Exception e) {
			fail();
		}*/
	}
}
