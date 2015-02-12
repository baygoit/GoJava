package ua.com.goit.gojava.andriidnikitin.model;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.util.OrderStatus;

public class Order {
	
	private Client client;
	
	private OrderStatus status;
	
	private List<OrderGood> goods;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderGood> getGoods() {
		return goods;
	}

	public void setGoods(List<OrderGood> goods) {
		this.goods = goods;
	}
	
	

}
