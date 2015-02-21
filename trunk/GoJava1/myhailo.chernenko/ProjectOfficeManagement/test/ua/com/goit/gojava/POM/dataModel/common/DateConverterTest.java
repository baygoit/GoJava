package ua.com.goit.gojava.POM.dataModel.common;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.common.DateConvertor;

public class DateConverterTest {

	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH/mm/sss/S");
    
	private Date date;
	
	private Date dateMillisecond;
	private Date dateSecond;
	private Date dateMinute;
	private Date dateHour;
	private Date dateDay;
	private Date dateMonth;
	private Date dateYear;
	
	
	@Before
	public void setUp() throws Exception {

		date = formatter.parse("05/05/2015/23/23/23/99");
		dateMillisecond = formatter.parse("05/05/2015/23/23/23/99");
		dateSecond = formatter.parse("05/05/2015/23/23/23/0");
		dateMinute = formatter.parse("05/05/2015/23/23/0/0");
		dateHour = formatter.parse("05/05/2015/23/0/0/0");
		dateDay = formatter.parse("05/05/2015/0/0/0/0");
		dateMonth = formatter.parse("01/05/2015/0/0/0/0");
		dateYear = formatter.parse("01/01/2015/0/0/0/0");
		
	}
	
	@Test
	public void testFor100PercentCoverage() throws ParseException {

		assertNotNull(new DateConvertor());

	}
	
	@Test
	public void testYear() throws ParseException {

		assertEquals(dateYear, DateConvertor.roundDate(date, Calendar.YEAR));

	}
	
	@Test
	public void testMonth() throws ParseException {

		
		assertEquals(dateMonth, DateConvertor.roundDate(date, Calendar.MONTH));
		
	}
	
	@Test
	public void testDay() throws ParseException {

		
		assertEquals(dateDay, DateConvertor.roundDate(date, Calendar.DAY_OF_MONTH));
		
	}
	
	@Test
	public void testHour() throws ParseException {

		
		assertEquals(dateHour, DateConvertor.roundDate(date, Calendar.HOUR_OF_DAY));
		
	}
	
	@Test
	public void testMinute() throws ParseException {

		
		assertEquals(dateMinute, DateConvertor.roundDate(date, Calendar.MINUTE));
		
	}
	
	@Test
	public void testSecond() throws ParseException {

		
		assertEquals(dateSecond, DateConvertor.roundDate(date, Calendar.SECOND));
		
	}
	
	@Test
	public void testMilliSecond() throws ParseException {

		
		assertEquals(dateMillisecond, DateConvertor.roundDate(date, Calendar.MILLISECOND));
		
	}

}
