package ua.com.goit.gojava2.vova.kickstarter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class PeriodBetweenDates {
    
	public static int periodJoda(String dateString){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int days = 0;
		try {
			Date  endDate = format.parse(dateString);
	    	DateTime start = new DateTime(new Date());
	    	DateTime end = new DateTime(endDate);
	
			Days d = Days.daysBetween(start, end);
			days = d.getDays();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}
    
	public static int period(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int difference = 0;
		try {
			Date d1 = new Date();
		    Calendar calendar1 = Calendar.getInstance();
		    calendar1.setTime(d1);

		    Date d2 = format.parse(date);
	    	Calendar calendar2 = Calendar.getInstance();
	    	calendar2.setTime(d2);

	    	while (calendar1.before(calendar2)) {
	    		calendar1.add(Calendar.DATE, 1);
	    		difference++;
	    	}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return difference;
	}
	
}
