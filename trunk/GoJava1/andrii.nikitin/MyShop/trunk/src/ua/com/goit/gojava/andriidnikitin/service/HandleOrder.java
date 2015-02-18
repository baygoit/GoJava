package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Order;

public interface HandleOrder {
	
	public List<Order> getOrders();
	public String getInfo(Order order);
	public Order nextUnhandledOrder();
	
}
