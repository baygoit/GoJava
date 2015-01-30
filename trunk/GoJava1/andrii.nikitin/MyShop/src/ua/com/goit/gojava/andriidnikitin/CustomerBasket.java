package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerBasket {

	void add(Good good, int quantity);
	
	public void delete (Good good);
	
	public void confirmOrder ();
	
	public void cancelOrder();
	
	public List<Good> getList();
	
	public BigDecimal total();
}
