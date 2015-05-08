package org.dens.kikstarter.data;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Project {
	
	private static final int DEFAULT_DAYS_LEFT = 365;
	private String name;
	private String description;
	private BigDecimal requiredFunds;
	private BigDecimal borrowedFunds;
	private int daysLeft;
	
	
	
	public Project(String name, String description, BigDecimal requiredFunds) {
		this.name = name;
		this.description = description;
		this.requiredFunds = requiredFunds;
		this.borrowedFunds = BigDecimal.ZERO;
		this.daysLeft = DEFAULT_DAYS_LEFT;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getRequiredFunds() {
		return requiredFunds;
	}
	public BigDecimal getBorrowedFunds() {
		return borrowedFunds;
	}
	public int getDaysLeft() {
		return daysLeft;
	}
	

}
