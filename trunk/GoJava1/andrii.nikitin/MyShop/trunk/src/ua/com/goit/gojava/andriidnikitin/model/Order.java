package ua.com.goit.gojava.andriidnikitin.model;

import java.util.Date;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.util.OrderStatus;

public class Order implements Comparable<Order> {
	
	private Client client;
	
	private OrderStatus status;
	
	private Boolean handled;	 
	
	private List<OrderGood> goods;
	
	private Date date;	

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

	public Boolean getHandled() {
		return handled;
	}

	public void setHandled(Boolean handled) {
		this.handled = handled;
	}

	@Override
	public int compareTo(Order arg0) {		
		return getDate().compareTo(arg0.getDate());	
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
