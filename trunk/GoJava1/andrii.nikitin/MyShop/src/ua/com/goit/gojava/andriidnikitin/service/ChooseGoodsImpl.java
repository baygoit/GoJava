package ua.com.goit.gojava.andriidnikitin.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import ua.com.goit.gojava.andriidnikitin.model.Basket;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Order;

public class ChooseGoodsImpl implements ChooseGoods  {
	
	protected Basket basket = new Basket();
	
	@Override
	public void add(Good good, int quantity) {
		Map<Good, Integer> map = basket.getOrder();
		if (map.containsKey(good)) {
			quantity += map.get(good);
		}
		if (quantity < 0) {
			quantity = 0;
		}
		map.put(good, quantity);
	}

	@Override
	public void delete(Good good) {
		basket.getOrder().remove(good);
		
	}

	@Override
	public Order confirmChoice() {
		Order order = new Order();
		order.setBasket(basket);
		return order;
	}

	@Override
	public void cancelChoice() {
		basket = new Basket();		
	}

	@Override
	public BigDecimal total() {
		BigDecimal result = new BigDecimal("0"); 
		Map<Good, Integer> order = basket.getOrder();
		for (Entry<Good, Integer> entry: order.entrySet()) {
			BigDecimal price = entry.getKey().getPrice();
			Integer quantity = entry.getValue();
			result = result.add(price.multiply(new BigDecimal(quantity)));
		}
		return result;
	}

}
