package ua.com.goit.gojava.andriidnikitin.model;

public class OrderGood {

	private Order order;
	   
	private Good good;
	   
	private int amount;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	} 
	
	
}
