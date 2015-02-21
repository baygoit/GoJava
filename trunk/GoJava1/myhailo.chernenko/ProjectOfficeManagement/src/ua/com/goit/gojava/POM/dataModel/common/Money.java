package ua.com.goit.gojava.POM.dataModel.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;

public class Money {
	
	private int scaleLength = 2;
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	private BigDecimal value;
	private Currency currency;
	
	public Money(Currency currency) {

		this.value = getDecimal(0.0);
		this.currency = currency;
		
	}

	public Money(Double value, Currency currency) throws POMDataModelException {
		
		this(currency);
		
		try {
			this.value = getDecimal(value);
		} catch (NumberFormatException | NullPointerException e) {
			throw new POMDataModelException("Wrong amount of Money", e);
		}

		
	}
	
	private BigDecimal getDecimal(Double value) {
		
		return new BigDecimal(value).setScale(scaleLength,roundingMode);
		
	}
	
	private BigDecimal getDecimal(long value) {
		
		return new BigDecimal(value).setScale(scaleLength,roundingMode);
		
	}
	
	
	public BigDecimal getValue() {
		
		return value;
	}

	public Currency getCurrency() {
		
		return currency;
	}

	public void divide(Long divisor) {
		
		this.value = this.value.divide(getDecimal(divisor), scaleLength, roundingMode);
		
	}
	
	public void multiply(Long multiplicand) {
		
		this.value = this.value.multiply(getDecimal(multiplicand));
		
	}
	
	public void add(Money money, ExchangeRate currentRate) throws POMDataModelException {
		
		if(this.getCurrency() == money.getCurrency()){
			
			this.value = this.value.add(money.getValue());
			
		}else{
			
			if( currentRate != null
					&&(currentRate.getFromCurrency() == money.getCurrency())
					&&(currentRate.getToCurrency() == this.getCurrency())) {
				
				BigDecimal reCalculatedValue = money.getValue();
				try {
					reCalculatedValue = reCalculatedValue.divide(getDecimal(currentRate.getRate()));
				} catch (ArithmeticException e) {
					throw new POMDataModelException("Wrong divisor ("+currentRate.getRate()+")",e);
				}
				
				reCalculatedValue = reCalculatedValue.multiply(getDecimal(currentRate.getMultiplicity()));

				this.value = this.value.add(reCalculatedValue.setScale(scaleLength, roundingMode));
						
			}else{
				
				throw new POMDataModelException("Can't add 2 Money in different currencies - rate is wrong or not found"); 
				
			}
			
		}
		
	}

	@Override
	public String toString() {

		return ""+getValue()+" "+getCurrency().getDisplayName();

	}

}
