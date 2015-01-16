package freetime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Employee extends User {

    final int DEFALT_HOURS_PER_DAY = 8;
    private int workTimePerDay;

    /* date is string yyyymmdd and free for work hours */
    private Map<Date, Integer> schedule = new HashMap<Date, Integer>();

    Employee() {
        super();
        workTimePerDay = DEFALT_HOURS_PER_DAY;
    }

    Employee(String name, String login, String password, String email,
            String phoneNumber) {
        super(name, login, password, email, phoneNumber);
        workTimePerDay = DEFALT_HOURS_PER_DAY;

    }
    
    public boolean isFree(Date checkingDate) {
        
        return (schedule.containsKey(checkingDate) ? true : false);
        
    }

}
