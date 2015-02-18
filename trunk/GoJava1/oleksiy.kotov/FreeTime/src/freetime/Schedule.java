package freetime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private Map<Date, DayStatus> days;

    public Schedule() {
        days = new HashMap<Date, DayStatus>();
    }

    public boolean isDayAvailable(Date date) {
        if (!days.containsKey(date)) {
            return false;
        }

        return days.get(date).isAvailable();
    }

    public void markDayFree(Date date) {
        days.put(date, new DayStatus());
    }
    
    public void markDayOff(Date date) {
        days.put(date, new DayStatus(true));
    }
    
    public int countAvailableDaysOfInterval(Date start, Date end) {
        
        Date date = start;
        end = DateUtil.addDays(end, 1);

        int freeDays = 0;
        while (date.before(end)) {

            if (isDayAvailable(date)) {
                freeDays += 1;
            }

            date = DateUtil.addDays(date, 1);
        }

        return freeDays;
    }
    
}
