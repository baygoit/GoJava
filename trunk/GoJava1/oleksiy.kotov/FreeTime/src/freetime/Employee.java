package freetime;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee extends User {

    //final static int DEFALT_HOURS_PER_DAY = 8;
    
    //private int workTimePerDay;
    private HashSet<String> skills;
    private HashSet<Date> freeDates;
    private HashSet<Date> busyDates;

    /* date is string yyyymmdd and free for work hours */
    //private Map<Date, Integer> schedule = new HashMap<Date, Integer>();

    Employee() {
        super();
        //workTimePerDay = DEFALT_HOURS_PER_DAY;
        skills = new HashSet<String>();
        freeDates = new HashSet<Date>();
        busyDates = new HashSet<Date>();
    }

    Employee(String name, String login, String password, String email,
            String phoneNumber) {
        this();
        setName(name);
        setLogin(login);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        //workTimePerDay = DEFALT_HOURS_PER_DAY;
        
    }
    
    // if Date is in the list, this day is free
    public boolean isDayFree(Date date) {
        return (freeDates.contains(date)) ? true : false;
    }
    
    public boolean isPeriodHasFreeDay(Date start, Date end) throws ParseException {
        
        Date date = start;
        end = DateUtil.addDays(end, 1);
        
        while (date.before(end)) {
            
            if (isDayFree(date)) {
                return true;
            }
            
            date = DateUtil.addDays(date, 1);
        }
        
        return false;
    }
    
    public void markDayFree(Date date) {
        
        freeDates.add(date);
        if (busyDates.contains(date)) {
            busyDates.remove(date);
        }
    }
    
    public void markDayBusy(Date date) {
        
        busyDates.add(date);
        if (freeDates.contains(date)) {
            freeDates.remove(date);
        }
    }
    
    public void addSkill(String newSkill) {
        String skill = new String (newSkill.toLowerCase());
        skills.add(skill);
    }
    
    public void removeSkill(String removingSkill) {
        String skill = new String (removingSkill.toLowerCase());
        if (skills.contains(skill)) {
            skills.remove(skill.toLowerCase());
        }
    }
    
    public boolean hasSkill(String skill) {
        return skills.contains(skill.toLowerCase()) ? true : false;
    }
    
    public HashSet<String> getSkills() {
        return skills;
    }
    
    public void setSkills(HashSet<String> skills) {
        this.skills = new HashSet<String>(skills);
    }
    
}
