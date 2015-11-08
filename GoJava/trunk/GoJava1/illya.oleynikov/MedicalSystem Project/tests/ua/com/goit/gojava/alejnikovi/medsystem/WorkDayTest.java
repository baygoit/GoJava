package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorkDayTest {
	
	static Date startTime;
	static Date endTime;
	static Date date;
	
	@BeforeClass
	public static void fillDate() {
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(2015, 1, 10, 9, 0);
		startTime = calendar.getTime();
		calendar.set(2015, 1, 10, 14, 0);
		endTime = calendar.getTime();
		calendar.set(2015, 1, 11, 0, 0);
		date = calendar.getTime();
		
	}

	@Test
	public void smokeTest() {
		assertNotNull(new WorkDay(null, null));
	}
	
	@Test
	public void testDate (){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		WorkDay workDay = new WorkDay(startTime, endTime);
		assertEquals(sdf.format(workDay.getWorkStartTime()), "10-02-2015");
	}
	
	@Test
	public void testDefaultTime (){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy, hh:mm");
		System.out.println(date);
		WorkDay workDay = new WorkDay(date);
		assertEquals(sdf.format(workDay.getWorkStartTime()), "11-02-2015, 09:00");
	}

}
