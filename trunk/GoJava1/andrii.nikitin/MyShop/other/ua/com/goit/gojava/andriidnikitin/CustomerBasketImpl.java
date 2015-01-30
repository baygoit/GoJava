package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerBasketImpl implements CustomerBasket {
	
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
	}

}
