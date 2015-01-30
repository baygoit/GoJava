package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Order {
	
	private Client client;
	private Date date;
	private Map<Good, Integer> orderedGoods;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Map<Good, Integer> getOrderedGoods() {
		return orderedGoods;
	}
	public void setOrderedGoods(Map<Good, Integer> orderedGoods) {
		this.orderedGoods = orderedGoods;
	}
	public BigDecimal total(){
		return new BigDecimal(0);
	}
	
}
