package ua.com.goit.gojava.POM.dataModel.common;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DateConvertor {
	
	private static Map<Integer, String> roundModeMap = new LinkedHashMap<Integer, String>();
	static {
		
		roundModeMap.put(Calendar.MILLISECOND, "Millisecond");
		roundModeMap.put(Calendar.SECOND, "Second");
		roundModeMap.put(Calendar.MINUTE, "Minute");
		roundModeMap.put(Calendar.HOUR_OF_DAY, "Hour");
		roundModeMap.put(Calendar.DAY_OF_MONTH, "Day");
		roundModeMap.put(Calendar.MONTH, "Month");
		roundModeMap.put(Calendar.YEAR, "Year");
		
	}
	
	public static Map<Integer, String> getSupportedRoundModes() {
		
		return roundModeMap;
	}
	
	public static Date roundDate(Date date, int roundindMode) {
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        for(Integer currentMode: roundModeMap.keySet()) { 
        
        	if(currentMode > roundindMode) {
        		
        		cal.set(currentMode, ( (currentMode >= Calendar.HOUR_OF_DAY) 
        								|| (currentMode <= Calendar.MONTH) 
        							 )? 0 : 1);
        		
        	}
        }
        
        return cal.getTime();
	}

}
