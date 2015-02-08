package ua.com.goit.gojava.andriidnikitin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.model.Basket;
import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Order;

public class ChooseGoodImplTest {
	
	@Test
	public void addTest(){
		ChooseGoodsImpl choser = new ChooseGoodsImpl();
		Good good  = new Good();
		good.setCategory(new Category());
		good.setId(123);
		good.setName("default");
		good.setPrice(new BigDecimal("10"));
		choser.add(good, 0);
		assertEquals(0, new BigDecimal("0").compareTo(choser.total()));
		choser.add(good, 5);
		assertEquals(0, new BigDecimal("50").compareTo(choser.total()));
		choser.add(good, -100);
		assertEquals(0, new BigDecimal("0").compareTo(choser.total()));
		choser.add(good, 5);
		choser.delete(good);
		assertTrue(choser.basket.getOrder().get(good) == null);
		assertEquals(0, new BigDecimal("0").compareTo(choser.total()));		
		Basket tempBasket = choser.basket;
		choser.cancelChoice();
		assertTrue(choser.basket != tempBasket);
	}
}	