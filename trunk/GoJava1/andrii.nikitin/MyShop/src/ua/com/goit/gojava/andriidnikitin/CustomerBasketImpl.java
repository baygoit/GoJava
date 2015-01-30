package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerBasketImpl implements CustomerBasket {
	
	private Map<Good, Integer> basket;
	
	public CustomerBasketImpl(){
		basket = new HashMap<Good, Integer>();
	}

	@Override
	public void add(Good good, int quantity) {		
		if (good == null) {
			throw new NullPointerException("Good is not have been initialized.");
		}
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
	public List<Good> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal total() {
		// TODO Auto-generated method stub
		return null;
	}

}
