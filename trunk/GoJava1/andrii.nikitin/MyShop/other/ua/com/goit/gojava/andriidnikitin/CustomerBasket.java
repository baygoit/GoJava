package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;

public interface CustomerBasket {

	void add(Good good, int quantity);
	
	public void delete (Good good);
	
	public void confirmOrder ();
	
	public void cancelOrder();
		
	public BigDecimal total();
}
