package ua.com.goit.gojava.POM.dataModel.common;

//import static org.junit.Assert.*;

/*import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
*/
//import org.junit.Before;
//import org.junit.Test;

//import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
//import ua.com.goit.gojava.POM.dataModel.POMDataModelRuntimeException;
//import ua.com.goit.gojava.POM.dataModel.temporaryUnusedClases.FinancialStatement;
//import ua.com.goit.gojava.POM.persistence.postgresDB.ExchangeRateDAO;

public class FinancialStatementTest {

	/*private int scaleLength = 2;
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	
	private BigDecimal getDecimal(Double value) {
		
		return new BigDecimal(value).setScale(scaleLength,roundingMode);
		
	}*/
	/*
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testFinancialStatement() {

		assertNotNull(new MyFinancialStatement());
		assertNotNull(new MyFinancialEntry());

	}

	@Test
	public void testGetNewInstanse() {

		MyFinancialStatement newInstance = new MyFinancialStatement();
		assertNotNull(newInstance.getNewInstanse());
		assertNotEquals(newInstance.getNewInstanse(), newInstance);
		
	}

	@Test
	public void testGetNewEntryInstance() {

		MyFinancialStatement newInstance = new MyFinancialStatement();
		assertNotNull(newInstance.getNewEntryInstance());
		
		FinancialStatement<FinancialEntry> financialStatement = new FinancialStatement<FinancialEntry>(FinancialEntry.class) {
			
			private static final long serialVersionUID = 3186316032061760202L;

			@Override
			public FinancialStatement<FinancialEntry> getNewInstanse() {
				return null;
			}
		};
		
		try { 
			financialStatement.getNewEntryInstance();
			fail("Here must be runtime exception... (Attempt to create Statement for abstract Entries )");
		} catch (POMDataModelRuntimeException e) {
			
		}
		
	}

	@Test
	public void testAddAndGetEntries() {

		MyFinancialStatement statement = new MyFinancialStatement();
		
		assertEquals(statement.getEntries().size(), 0);
		
		MyFinancialEntry newEntry1 = statement.addEntry();
		MyFinancialEntry newEntry2 = statement.addEntry();
		
		assertEquals(statement.getEntries().size(), 2);
		
		assertEquals(newEntry1.getId(), 1);
		assertEquals(newEntry2.getId(), 2);
		
		/*statement.deleteDocEntries(null);
		newEntry1 = statement.addEntry();
		statement.getEntries().set(0, null);
		
		newEntry2 = statement.addEntry();
		assertEquals(newEntry2.getId(), 1);
		
		// for 100% coverage :)
		newEntry2.setDescription("");
		assertEquals(newEntry2.getDescription(), "");
		
		
	}

	@Test
	public void testDeleteDocEntries() {

		MyFinancialStatement statement = new MyFinancialStatement();
		
		MyFinancialEntry newEntry1 = statement.addEntry();
		statement.addEntry();
		MyFinancialEntry newEntry3 = statement.addEntry();
		statement.addEntry();
		
		/*FinancialDocument finDoc = new FinancialDocument() {};
		newEntry1.setDoc(finDoc);
		newEntry3.setDoc(finDoc);
		
		assertEquals(statement.getEntries().size(), 4);
		
		//statement.deleteDocEntries(null);
		
		assertEquals(statement.getEntries().size(), 2);
		assertEquals(statement.getEntries().get(0), newEntry1);
		assertEquals(statement.getEntries().get(1), newEntry3);
		assertEquals(statement.getEntries().size(), 2);
		
		MyFinancialEntry newEntry2 = statement.addEntry();
		
		//statement.deleteDocEntries(finDoc);
		
		assertEquals(statement.getEntries().get(0), newEntry2);
			
	}

	@Test
	public void testGetTotal() {

		/*MyFinancialStatement statement = new MyFinancialStatement();
		MyFinancialEntry newEntry1 = statement.addEntry();
		MyFinancialEntry newEntry2 = statement.addEntry();
		MyFinancialEntry newEntry3 = statement.addEntry();
		MyFinancialEntry newEntry4 = statement.addEntry();
		
		try {
			newEntry1.setSum(new Money(10.35,Currency.getInstance("UAH")));
			newEntry2.setSum(new Money(11.36,Currency.getInstance("USD")));
			newEntry3.setSum(new Money(12.37,Currency.getInstance("UAH")));
			newEntry4.setSum(new Money(13.38,Currency.getInstance("UAH")));
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
		}
		
		/*FinancialCharacteristic characteristic1 = new FinancialCharacteristic() { };
		FinancialCharacteristic characteristic2 = new FinancialCharacteristic() { };
		newEntry1.setCharacteristic(characteristic1);
		newEntry2.setCharacteristic(characteristic1);
		newEntry3.setCharacteristic(characteristic2);
		newEntry4.setCharacteristic(characteristic2);
		
		try {
			assertEquals(statement.getTotal(characteristic2, Currency.getInstance("UAH")).getValue(),
					getDecimal(25.75));
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
		}
		
		try {
			assertEquals(statement.getTotal(characteristic1, Currency.getInstance("UAH")).getValue(),
					getDecimal(21.71));
			fail("Here must be exception... (zero currency rate)");
		} catch (POMDataModelException e) {
			
		}
		 */
		// TODO rewrite 
		/*

		Date date = Calendar.getInstance().getTime();
		
		ExchangeRate currencyRate = new ExchangeRateDAO(statement.getDataManager()).create();
		currencyRate.setDate(date);
		currencyRate.setFromCurrency(Currency.getInstance("USD"));
		currencyRate.setToCurrency(Currency.getInstance("UAH"));
		currencyRate.setMultiplicity(1);
		currencyRate.setRate(1);
		
		newEntry2.setDate(Calendar.getInstance().getTime());;
		
		try {
			assertEquals(statement.getTotal(null, Currency.getInstance("UAH")).getValue(),
					getDecimal(47.46));
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
		}
	
	}

	// TODO debatable functional
	/*
	@Test
	public void testGetRolledUp() {

		MyFinancialStatement statement = new MyFinancialStatement();
		MyFinancialEntry newEntry1 = statement.addEntry();
		MyFinancialEntry newEntry2 = statement.addEntry();
		MyFinancialEntry newEntry3 = statement.addEntry();
		MyFinancialEntry newEntry4 = statement.addEntry();
		
		Date date1, date2, date3, date4;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH/mm/sss/S");
		try {
			newEntry1.setSum(new Money(10.35,Currency.getInstance("UAH")));
			newEntry2.setSum(new Money(11.36,Currency.getInstance("USD")));
			newEntry3.setSum(new Money(12.37,Currency.getInstance("UAH")));
			newEntry4.setSum(new Money(13.38,Currency.getInstance("UAH")));
			
			date1 = formatter.parse("05/05/2015/23/23/23/99");
			date2 = formatter.parse("02/05/2015/23/23/23/99");
			date3 = formatter.parse("05/04/2015/23/23/23/99");
			date4 = formatter.parse("05/05/2014/23/23/23/99");
			
		} catch (POMDataModelException|ParseException e) {
			fail("Here must not be exception...");
			return;
		}
		
	
		ExchangeRate currencyRate = new ExchangeRateDAO(statement.getDataManager()).create();
		currencyRate.setDate(date4);
		currencyRate.setFromCurrency(Currency.getInstance("USD"));
		currencyRate.setToCurrency(Currency.getInstance("UAH"));
		currencyRate.setMultiplicity(1);
		currencyRate.setRate(1);
		
		newEntry1.setDate(date1);
		newEntry2.setDate(date2);
		newEntry3.setDate(date3);
		newEntry4.setDate(date4);
		
		FinancialStatement<MyFinancialEntry> rolledUp;
		try {
			rolledUp = statement.getRolledUp(Calendar.YEAR);
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
			return;
		}
		
		assertEquals(rolledUp.getEntries().size(), 2);
		assertEquals(rolledUp.getEntries().get(0).getSum().getValue(), getDecimal(34.08));
		assertEquals(rolledUp.getEntries().get(1).getSum().getValue(), getDecimal(13.38));
		
	}

	@Test
	public void testGetDifference() {

		MyFinancialStatement statement = new MyFinancialStatement();
		MyFinancialEntry newEntry1 = statement.addEntry();
		MyFinancialEntry newEntry2 = statement.addEntry();
		MyFinancialEntry newEntry3 = statement.addEntry();
		MyFinancialEntry newEntry4 = statement.addEntry();
		
		Date date1, date2, date3, date4;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH/mm/sss/S");
		try {
			newEntry1.setSum(new Money(10.35,Currency.getInstance("UAH")));
			newEntry2.setSum(new Money(11.36,Currency.getInstance("UAH")));
			newEntry3.setSum(new Money(12.37,Currency.getInstance("UAH")));
			newEntry4.setSum(new Money(13.38,Currency.getInstance("UAH")));
			
			date1 = formatter.parse("05/05/2015/23/23/23/99");
			date2 = formatter.parse("02/05/2015/23/23/23/99");
			date3 = formatter.parse("05/04/2015/23/23/23/99");
			date4 = formatter.parse("05/05/2014/23/23/23/99");
			
		} catch (POMDataModelException|ParseException e) {
			fail("Here must not be exception...");
			return;
		}
		
	
		newEntry1.setDate(date1);
		newEntry2.setDate(date2);
		newEntry3.setDate(date3);
		newEntry4.setDate(date4);
		
		FinancialStatement<MyFinancialEntry> rolledUp;
		try {
			rolledUp = statement.getRolledUp(Calendar.YEAR);
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
			return;
		}
		
		assertEquals(rolledUp.getEntries().size(), 2);
		assertEquals(rolledUp.getEntries().get(0).getSum().getValue(), getDecimal(34.08));
		assertEquals(rolledUp.getEntries().get(1).getSum().getValue(), getDecimal(13.38));
		
		FinancialStatement<MyFinancialEntry> difference;
		try {
			newEntry4.setSum(new Money(13.39,Currency.getInstance("UAH")));
			difference = statement.getDifference(rolledUp, Calendar.YEAR);
		} catch (POMDataModelException e) {
			fail("Here must not be exception...");
			return;
		}
		
		assertEquals(difference.getEntries().size(), 2);
		// TODO need to check
		//assertEquals(difference.getEntries().get(0).getSum().getValue(), getDecimal(0.0));
		//assertEquals(difference.getEntries().get(1).getSum().getValue(), getDecimal(0.02));
		
	}
	*/
}

