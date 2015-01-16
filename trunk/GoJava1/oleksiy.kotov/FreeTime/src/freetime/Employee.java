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
    
    // if Date is in the list, this day is free
    public boolean isFree(Date checkingDate) {
        
        return (schedule.containsKey(checkingDate) ? true : false);
        
    }
    
    public void becomBusy(Date checkingDate) {
        
        this.schedule.put(checkingDate, workTimePerDay);
        
    }
    
    public void addFreeDay(Date freeDate) {
        
        this.schedule.put(freeDate, workTimePerDay);
        
    }

    public Map<Date, Integer> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<Date, Integer> schedule) {
        this.schedule = schedule;
    }
    
    

}
