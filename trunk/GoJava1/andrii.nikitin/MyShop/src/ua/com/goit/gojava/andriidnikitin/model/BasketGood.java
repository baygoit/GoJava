package ua.com.goit.gojava.andriidnikitin.model;

public class BasketGood {

	private Basket basket;
	
	private Good good; 
	
	private int amount;

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
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
