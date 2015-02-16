package ua.com.goit.gojava.andriidnikitin.model;

import java.util.Date;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.util.OrderStatus;

public class Order {
	
	private Client client;
	
	private OrderStatus status;
	
	private Boolean handled;	 
	
	private List<OrderEntry> goods;
	
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

	public List<OrderEntry> getGoods() {
		return goods;
	}

	public void setGoods(List<OrderEntry> goods) {
		this.goods = goods;
	}

	public Boolean getHandled() {
		return handled;
	}

	public void setHandled(Boolean handled) {
		this.handled = handled;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
