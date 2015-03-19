package ua.com.goit.gojava.andriidnikitin.MyShop3.domain.service;

import java.math.BigDecimal;

import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model.Good;


public interface DeliveryManager {
	
	public void deliverGood(Good good, Integer quantity, BigDecimal price);


}
