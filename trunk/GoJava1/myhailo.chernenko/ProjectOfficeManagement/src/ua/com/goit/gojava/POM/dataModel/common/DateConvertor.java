package ua.com.goit.gojava.POM.dataModel.common;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateConvertor {
	
	public static Date roundDate(Date date, int roundindMode) {
		
		List<Integer> roundingModes = Arrays.asList(Calendar.MILLISECOND, 
													Calendar.SECOND,
													Calendar.MINUTE,
													Calendar.HOUR_OF_DAY,
													//Calendar.DAY_OF_WEEK_IN_MONTH,
													Calendar.DAY_OF_MONTH,
													Calendar.MONTH,
													Calendar.YEAR
												);
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        for(Integer currentMode: roundingModes) { 
        
        	if(currentMode > roundindMode) {
        		
        		cal.set(currentMode, ( (currentMode >= Calendar.HOUR_OF_DAY) 
        								|| (currentMode <= Calendar.MONTH) 
        							 )? 0 : 1);
        		
        	}
        }
        
        return cal.getTime();
	}

}
