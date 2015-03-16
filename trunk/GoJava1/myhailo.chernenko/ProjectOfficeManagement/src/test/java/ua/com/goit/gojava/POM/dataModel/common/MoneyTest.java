package ua.com.goit.gojava.POM.dataModel.common;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;

public class MoneyTest {

	private int scaleLength = 2;
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	
	private BigDecimal getDecimal(Double value) {
		
		return new BigDecimal(value).setScale(scaleLength,roundingMode);
		
	}
	
	private void checkDivideMoneyResult(Double div, long divisor, Double result) {

		Money m;
		try {
			m = new Money(div, null);
		} catch (POMDataModelException e) {
			fail("Can't create money from "+div+": "+e.getMessage());
			return;
		}
		m.divide(divisor);
		
		assertEquals(m.getValue().compareTo(getDecimal(result)), 0);
		
	}
	
	private void checkAddMoneyResult(Double val1, String cur1, Double val2, String cur2,
			long rate, long multiplicity, Double result) {

		Money m1, m2;
		try {
			m1 = new Money(val1, Currency.getInstance(cur1));
			m2 = new Money(val2, Currency.getInstance(cur2));
		} catch (POMDataModelException e) {
			fail("Can't create money from "+val1+" or "+val2+": "+e.getMessage());
			return;
		}
		ExchangeRate currentRate = new ExchangeRate();
		currentRate.setFromCurrency(m2.getCurrency());
		currentRate.setToCurrency(m1.getCurrency());
		
		currentRate.setMultiplicity(multiplicity);
		currentRate.setRate(rate);
		try {
			m1.add(m2, currentRate);
		} catch (POMDataModelException e) {
			
			fail("Here must not be exception ... ("+e.getMessage()+")");
		};
		
		assertEquals(m1.getValue().compareTo(getDecimal(result)), 0);
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMoneyCurrency() {

		/*Money m = new Money(null);
		
		assertNotNull(m);
		
		assertEquals(m.getValue().compareTo(getDecimal(0.0)), 0);*/
		
	}

	@Test
	public void testMoneyDoubleCurrency() {

	/*	Money m;
		try {
			m = new Money(1.1, null);
		} catch (POMDataModelException e) {
			fail("Can't create money: "+e.getMessage());
			return;
		}
		
		assertNotNull(m);
		assertEquals(m.getValue().compareTo(getDecimal(1.1)), 0);*/
		
	}
	
	@Test
	public void testMoneyDoubleCurrencyExeption() {

		/*try {
			
			new Money(null, null);
			
			fail("Here must be exception...");
			
		} catch (POMDataModelException e) {

			
		}
		
		try {
			
			new Money(Double.NaN, null);
			
			fail("Here must be exception...");
			
		} catch (POMDataModelException e) {

			
		}*/
		
	}

	@Test
	public void testDivide() {

		/*checkDivideMoneyResult(2.0, 2L, 1.0);
		checkDivideMoneyResult(3.0, 2L, 1.5);
		checkDivideMoneyResult(10.0, 3L, 3.33);
		checkDivideMoneyResult(24.54, 10L, 2.45);
		checkDivideMoneyResult(24.55, 10L, 2.46);*/
			
	}
	
	@Test
	public void testMultiply() {

		/*Money m;
		try {
			m = new Money(3.33, null);
		} catch (POMDataModelException e) {
			fail("Can't create money: "+e.getMessage());
			return;
		}
		m.multiply(100L);
		
		assertEquals(m.getValue().compareTo(getDecimal(333.0)), 0);*/
		
	}

	@Test
	public void testAddSameCurrency() {

		/*Money m1, m2;
		try {
			m1 = new Money(3.33, null);
			m2 = new Money(3.33, null);
		} catch (POMDataModelException e) {
			fail("Can't create money: "+e.getMessage());
			return;
		}
		
		try {
			m1.add(m2, null);
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
		};
		
		assertEquals(m1.getValue().compareTo(getDecimal(6.66)), 0);*/
	}
	
	@Test
	public void testAddDiffCurrency() {

		/*Money m1, m2;
		try {
			m1 = new Money(3.33, Currency.getInstance("UAH"));
			m2 = new Money(3.33, Currency.getInstance("USD"));
		} catch (POMDataModelException e) {
			fail("Can't create money: "+e.getMessage());
			return;
		}
		
		try {
			m1.add(m2, null);
			fail("Here must be exception (null- currency rate)...");
		} catch (POMDataModelException e) {
			
		};
		
		try {
			m1.add(m2, new ExchangeRate());
			fail("Here must be exception (wrong currency rate)...");
		} catch (POMDataModelException e) {
			
		};
		
		ExchangeRate currentRate = new ExchangeRate();
		currentRate.setFromCurrency(m2.getCurrency());
		try {
			m1.add(m2, currentRate);
			fail("Here must be exception (wrong currency rate)...");
		} catch (POMDataModelException e) {
			
		};
		
		currentRate.setFromCurrency(null);
		currentRate.setToCurrency(m1.getCurrency());
		try {
			m1.add(m2, currentRate);
			fail("Here must be exception (wrong currency rate)...");
		} catch (POMDataModelException e) {
			
		};
		
		currentRate.setFromCurrency(m2.getCurrency());
		currentRate.setToCurrency(m1.getCurrency());
		try {
			m1.add(m2, currentRate);
			fail("Here must be exception (not initialized rate and\\or multiplicity)...");
		} catch (POMDataModelException e) {
			
		};
		
		checkAddMoneyResult(1.0, "UAH", 1.0, "USD", 1, 1, 2.0 );
		checkAddMoneyResult(3.33, "UAH", 3.33, "USD", 1, 30, 103.23 );
		checkAddMoneyResult(3.33, "UAH", 3.33, "USD", 30, 1, 3.44 );
		checkAddMoneyResult(3.33, "UAH", 3.33, "USD", 300, 10, 3.44 );
		checkAddMoneyResult(3.33, "UAH", 3.33, "USD", 3, 10, 14.43 );
		checkAddMoneyResult(3.33, "UAH", -3.33, "USD", 3, 10, -7.77 );*/
	}

	@Test
	public void testToString() {

		Money m1;
		try {
			m1 = new Money(3.3333, Currency.getInstance("UAH"));
		} catch (POMDataModelException e) {
			fail("Can't create money: "+e.getMessage());
			return;
		}
		
		assertEquals(m1.toString(), "3.33 Ukrainian Hryvnia");
		
	}

}
