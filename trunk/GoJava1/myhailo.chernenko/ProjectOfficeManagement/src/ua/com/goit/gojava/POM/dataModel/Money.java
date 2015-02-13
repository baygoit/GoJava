package ua.com.goit.gojava.POM.dataModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Money {
	
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	private BigDecimal value;
	private Currency currency;
	
	/*public Money(BigDecimal value, Currency currency) {
		
		this.value = value;
		this.currency = currency;
		SetScale();
		
	}
	
	public Money(Long value, Currency currency) {
		
		this.value = new BigDecimal(value);
		this.currency = currency;
		SetScale();
		
	}
	*/
	
	public Money(Double value, Currency currency) {
		
		this.value = new BigDecimal(value);
		this.currency = currency;
		SetScale();
		
	}
	
	private void SetScale() {
		
		this.value.setScale(2, roundingMode);
		
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
	
	public void add(Money money, ExchangeRate currentRate) {
		
		if(this.getCurrency() == money.getCurrency()){
			
			this.value = this.value.add(money.getValue());
			
		}else{
			
			if((currentRate.getFromCurrency() == money.getCurrency())
					&&(currentRate.getToCurrency() == this.getCurrency())) {
				
				BigDecimal reCalculatedValue = money.getValue();
				reCalculatedValue.divide(new BigDecimal(currentRate.getRate()));
				reCalculatedValue.multiply(new BigDecimal(currentRate.getMultiplicity()));

				this.value = this.value.add(reCalculatedValue);
						
			}else{
				
				// Exception
			}
			
		}
		
	}

}
