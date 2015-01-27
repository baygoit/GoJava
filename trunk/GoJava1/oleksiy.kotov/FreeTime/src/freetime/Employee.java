package freetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Employee extends User {

    final static int DEFALT_HOURS_PER_DAY = 8;
    
    private int workTimePerDay;
    private Set<String> skills;

    /* date is string yyyymmdd and free for work hours */
    private Map<Date, Integer> schedule = new HashMap<Date, Integer>();

    Employee() {
        super();
        workTimePerDay = DEFALT_HOURS_PER_DAY;
        skills = new HashSet<String>();
    }

    Employee(String name, String login, String password, String email,
            String phoneNumber) {
        this();
        setName(name);
        setLogin(login);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        workTimePerDay = DEFALT_HOURS_PER_DAY;
        
    }
    
    // if Date is in the list, this day is free
    public boolean isDayFree(Date date) {
        
        return (schedule.containsKey(date) ? true : false);
        
    }
    
    public boolean isPeriodHasFreeDay(Date dateStart, Date dateEnd) throws ParseException {
        
        Date date = dateStart;
        
        while (date.before(dateEnd)) {
            
            if (schedule.containsKey(date)) {
                return true;
            }
            
            date = DateUtil.addDays(date, 1);
        }
        
        return false;
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
    
    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
    
}
