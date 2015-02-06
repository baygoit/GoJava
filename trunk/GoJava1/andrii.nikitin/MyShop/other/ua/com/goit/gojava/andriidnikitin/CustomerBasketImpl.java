package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;
import java.util.Map;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Basket;
import ua.com.goit.gojava.andriidnikitin.model.Order;
import ua.com.goit.gojava.andriidnikitin.service.ChooseGoods;

public class CustomerBasketImpl implements ChooseGoods {

	@Override
	public void add(Good good, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Good good) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal total() {
		// TODO Auto-generated method stub
		return null;
	}/*
	
	private Order order;
	
	public CustomerBasketImpl(){
		order= new Order ();
	}

	@Override
	public void add(Good good, int quantity) {		
		if (good == null) {
			throw new NullPointerException("Good is not have been initialized.");
		}
		Map <Good, Integer> basket = order.getOrderedGoods(); 
		if (basket.containsKey(good)){
			int oldValue = basket.get(good);
			basket.put(good, quantity + oldValue);
		}
		basket.put(good, quantity);
	}

	@Override
	public void delete(Good good) {
		if (good == null) {
			throw new NullPointerException("Good is not have been initialized.");
		}
		Map <Good, Integer> basket = order.getOrderedGoods(); 
		if (basket.containsKey(good)) {
			basket.remove(good);
		}
	}

	@Override
	public void confirmOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public BigDecimal total() {
		return null;
	}*/

	
	@Override
	public void cancelChoice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order confirmChoice() {
		// TODO Auto-generated method stub
		return null;
	}

}
