package ua.com.goit.gojava.andriidnikitin.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;
import ua.com.goit.gojava.andriidnikitin.service.GoodSuppliesImpl;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;


public class GoodCatalogImplTest {
	
	@Test
	public void getGoodTypesFromRootTest() {
		final GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
		final List<GoodType> list = catalog.getGoodTypesFromRoot();
		assertNotNull(list);
		
		
	}
	
	@Test
	public void getFromFileTest(){
		final GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
		try {
			catalog.initFromFile(null);
			fail();
		} catch (ShopException e) {
		}
		try {
			catalog.initFromFile("default#*/unexi...sting_filepath@&%^");//such file does not exist!
			fail();
		} catch (ShopException e) {
		}
	}
	
	@Test
	public void goodSuppliesImplTest(){
		final GoodSuppliesImpl instance = GoodSuppliesImpl.getInstance();
		assertNotNull(instance);
	}

}
