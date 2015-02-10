package ua.com.goit.gojava.andriidnikitin.service;

import java.math.BigDecimal;

import ua.com.goit.gojava.andriidnikitin.Good;
import ua.com.goit.gojava.andriidnikitin.Order;

public interface ChooseGoods {

	public void add(Good good, int quantity);
	
	public void delete (Good good);
	
	public Order confirmChoice ();
	
	public void cancelChoice();
		
	public BigDecimal total();
}
