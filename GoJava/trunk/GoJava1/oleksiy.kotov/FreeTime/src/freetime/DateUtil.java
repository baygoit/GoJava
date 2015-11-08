package freetime;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    
    public static Date today()  {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
}
