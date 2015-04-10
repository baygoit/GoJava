package ua.com.goit.gojava.POM.dataModel.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;

@Embeddable
public class Money {
	
	private static final Logger LOG=Logger.getLogger(Money.class);
	
	@Transient
	private int scaleLength = 2;
	
	@Transient
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	
	@Column
	private BigDecimal value;
	
	@Column
	private Currency currency;
	
	public Money() {

	}
	
	public Money(Currency currency) {

		this.value = getDecimal(0.0);
		this.currency = currency;
		
	}

	public Money(BigDecimal value, Currency currency) throws POMDataModelException {
		
		this(currency);
		this.value = value;
		
	}
	
	public Money(Double value, Currency currency) throws POMDataModelException {
		
		this(currency);
		
		try {
			this.value = getDecimal(value);
		} catch (NumberFormatException | NullPointerException e) {
			
			if(LOG.isDebugEnabled()){
				LOG.debug("Money creation: value = "+value);
			}
			LOG.error("Money creation. Wrong amount of Money: value = "+value);
			
			throw new POMDataModelException("Wrong amount of Money", e);
		}

		
	}
	
	public Money(Money money) {

		this.value = money.getValue();
		this.currency = money.getCurrency();
		
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
	
	public void add(Money sum) throws POMDataModelException {
		
		if(this.getCurrency() != sum.getCurrency()){
			
			LOG.error("Adding money. Money for adding has another currency!");
			throw new POMDataModelException("Adding money. Money for adding has another currency!");
			
		} else {
			
			this.value = this.value.add(sum.getValue());
			
		}
		
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
					
					LOG.error("Adding money. Wrong divisor ("+currentRate.getRate()+")");
					throw new POMDataModelException("Wrong divisor ("+currentRate.getRate()+")",e);
				}
				
				reCalculatedValue = reCalculatedValue.multiply(getDecimal(currentRate.getMultiplicity()));

				this.value = this.value.add(reCalculatedValue.setScale(scaleLength, roundingMode));
						
			}else{
				
				LOG.error("Adding money. Can't add 2 Money in different currencies - rate is wrong or not found");
				if(LOG.isDebugEnabled()){
					LOG.debug("Adding money. 	CurrentRate = "+currentRate);
					LOG.debug("Adding money. 	currentRate.getFromCurrency() = "+currentRate.getFromCurrency());
					LOG.debug("Adding money. 	currentRate.getToCurrency() = "+currentRate.getToCurrency());
					LOG.debug("Adding money. 	money.getCurrency() = "+money.getCurrency());
					LOG.debug("Adding money. 	this.getCurrency() = "+this.getCurrency());
				}
				throw new POMDataModelException("Can't add 2 Money in different currencies - rate is wrong or not found"); 
				
			}
			
		}
		
	}

	@Override
	public String toString() {

		return ""+getValue()+" " + ( (getCurrency() == null) ? "" : getCurrency().getDisplayName());

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((roundingMode == null) ? 0 : roundingMode.hashCode());
		result = prime * result + scaleLength;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (roundingMode != other.roundingMode)
			return false;
		if (scaleLength != other.scaleLength)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
