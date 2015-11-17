package ua.com.goit.gojava7.kickstarter.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.util.Utils;

public class UtilsTest {

	@Test
	public void testDateFromStringString() {
		Date dateFromString = Utils.dateFromString("10.11.2012");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFromString);
		
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(10));
		assertThat(calendar.get(Calendar.MONTH), is(Calendar.NOVEMBER));
		assertThat(calendar.get(Calendar.YEAR), is(2012));
	}
	
	@Test
	public void testDateFromStringStringError() {
		Date dateFromString = Utils.dateFromString("2012");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(dateFromString);
		
		Calendar calendar2 = Calendar.getInstance();
		
		assertThat(calendar1.get(Calendar.DAY_OF_MONTH), is(calendar2.get(Calendar.DAY_OF_MONTH)));
		assertThat(calendar1.get(Calendar.MONTH), is(calendar2.get(Calendar.MONTH)));
		assertThat(calendar1.get(Calendar.YEAR), is(calendar2.get(Calendar.YEAR)));
	}

	@Test
	public void testDateFromStringStringString() {
		Date dateFromString = Utils.dateFromString("yyyy.dd.MM", "2012.10.11");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFromString);
		
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(10));
		assertThat(calendar.get(Calendar.MONTH), is(Calendar.NOVEMBER));
		assertThat(calendar.get(Calendar.YEAR), is(2012));
	}

	@Test
	public void testAddToDate() {
		Date date1 = Utils.dateFromString("10.11.2012");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Utils.addToDate(date1, 1, Calendar.MONTH));
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(10));
		assertThat(calendar.get(Calendar.MONTH), is(Calendar.DECEMBER));
		assertThat(calendar.get(Calendar.YEAR), is(2012));
		
		calendar.setTime(Utils.addToDate(date1, 1, Calendar.YEAR));
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(10));
		assertThat(calendar.get(Calendar.MONTH), is(Calendar.NOVEMBER));
		assertThat(calendar.get(Calendar.YEAR), is(2013));
		
		calendar.setTime(Utils.addToDate(date1, 10, Calendar.DAY_OF_MONTH));
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(20));
		assertThat(calendar.get(Calendar.MONTH), is(Calendar.NOVEMBER));
		assertThat(calendar.get(Calendar.YEAR), is(2012));
	}

}
