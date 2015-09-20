package ua.scread.cash;

public class Check {
	private String purchaseName;
	private int amount = 0;
	private double price = 0;
	private double total = 0;
	
	public Check(String purchaseName, int amount, double price) {
		this.purchaseName = purchaseName;
		this.amount = amount;
		this.price = price;
		calculateTotal();
	}
	
	private void calculateTotal() {
		total += price*amount;
	}
	
	public double getTotal() {
		return total;
	}

}
