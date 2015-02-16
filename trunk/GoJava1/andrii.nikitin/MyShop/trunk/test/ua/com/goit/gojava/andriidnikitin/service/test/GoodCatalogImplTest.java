package ua.com.goit.gojava.andriidnikitin.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;


public class GoodCatalogImplTest {
	
	@Test
	public void getGoodTypesFromRootTest() {
		GoodCatalogImpl catalog = new GoodCatalogImpl();
		List<GoodType> list = catalog.getGoodTypesFromRoot();
		assertNotNull(list);
		
	}

}
