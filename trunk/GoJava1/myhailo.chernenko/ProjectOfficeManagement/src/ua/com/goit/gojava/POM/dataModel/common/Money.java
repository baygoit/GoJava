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

		this.value = new BigDecimal(0.0);
		this.currency = currency;
		SetScale();
	
	}

	public Money(Double value, Currency currency) throws POMDataModelException {
		
		this(currency);
		
		try {
			this.value = new BigDecimal(value);
		} catch (NumberFormatException e) {
			throw new POMDataModelException("Wrong amount of Money", e);
		}

		
	}
	
	private void SetScale() {
		
		this.value.setScale(scaleLength, roundingMode);
		
	}
	
	public BigDecimal getValue() {
		
		return value;
	}

	public Currency getCurrency() {
		
		return currency;
	}

	public void divide(Long divisor) {
		
		this.value.divide(new BigDecimal(divisor));
		
	}
	
	public void multiply(Long multiplicand) {
		
		this.value.multiply(new BigDecimal(multiplicand));
		
	}
	
	public void add(Money money, ExchangeRate currentRate) throws POMDataModelException {
		
		if(this.getCurrency() == money.getCurrency()){
			
			this.value = this.value.add(money.getValue());
			
		}else{
			
			if( currentRate != null
					&&(currentRate.getFromCurrency() == money.getCurrency())
					&&(currentRate.getToCurrency() == this.getCurrency())) {
				
				BigDecimal reCalculatedValue = money.getValue();
				reCalculatedValue.divide(new BigDecimal(currentRate.getRate()));
				reCalculatedValue.multiply(new BigDecimal(currentRate.getMultiplicity()));

				this.value = this.value.add(reCalculatedValue);
						
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
