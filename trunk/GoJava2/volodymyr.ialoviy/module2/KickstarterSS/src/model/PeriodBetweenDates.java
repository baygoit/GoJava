package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormat;

public class PeriodBetweenDates {
    public static void main(String[] args) {
    	System.out.println(period("2015-02-25"));
    	periodJoda("2015-02-25");
    }
    
	public static void periodJoda(String dateString){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date  endDate = format.parse(dateString);

	    	DateTime start = new DateTime(new Date());
	    	DateTime end = new DateTime(endDate);
			
	
			Days d = Days.daysBetween(start, end);
			int days = d.getDays();
			
			System.out.println("days = " + days);
			
			Period p = new Period(start, end, PeriodType.yearMonthDay());
			
			String sdsd = "" + p;
			
			System.out.println(PeriodFormat.getDefault().print(p));
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
