package freetime;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedSet;

public class Employee {

    // final static int DEFALT_HOURS_PER_DAY = 8;

    private String name;
    private HashSet<String> skills;
    private Map<Date, DayStatus> daysSchedule;

    /* date is string yyyymmdd and free for work hours */
    // private Map<Date, Integer> schedule = new HashMap<Date, Integer>();

    Employee() {
        // workTimePerDay = DEFALT_HOURS_PER_DAY;
        this.setName(new String("NONAME"));
        this.skills = new HashSet<String>();
        this.daysSchedule = new HashMap<Date, DayStatus>();

    }

    Employee(String name, String login, String password, String email,
            String phoneNumber) {
        this();
        setName(name);
        // workTimePerDay = DEFALT_HOURS_PER_DAY;

    }

    // if Date is in the list, this day is free
    public boolean isDayFree(Date date) {
        if (daysSchedule.containsKey(date)) {
            return daysSchedule.get(date).isAvailable();
        } else {
            return false;
        }

    }

    public boolean isPeriodHasFreeDay(Date start, Date end) {

        return (0 < getCountFreeDays(start, end)) ? true : false;
    }

    public void markDayFree(Date date) {

        //freeDates.add(date);
        // if (busyDates.contains(date)) {
        // busyDates.remove(date);
        // }
    }

    public void markDayBusy(SortedSet<Date> dates) {

        // busyDates.add(dates);
        // if (freeDates.contains(dates)) {
        // freeDates.remove(dates);
        // }
    }

    public void addSkill(String newSkill) {
        String skill = new String(newSkill.toLowerCase());
        skills.add(skill);
    }

    public void removeSkill(String removingSkill) {
        String skill = new String(removingSkill.toLowerCase());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountFreeDays(Date start, Date end) {
        
        Date date = start;
        end = DateUtil.addDays(end, 1);

        int freeDays = 0;
        while (date.before(end)) {

            if (isDayFree(date)) {
                freeDays += 1;
            }

            date = DateUtil.addDays(date, 1);
        }

        return freeDays;
    }

}
