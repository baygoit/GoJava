package freetime;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Employee implements Serializable{

    // final static int DEFALT_HOURS_PER_DAY = 8;
    
    private int id;
    private String name;
    private Set<String> skills;
    private Schedule schedule;
    
    public Employee(int id, String name, String skills) {
        this.id = id;
        this.name = name;
        this.skills = new HashSet<String>(Arrays.asList(skills.split(",")));
        this.schedule = new Schedule();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((skills == null) ? 0 : skills.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (skills == null) {
            if (other.skills != null)
                return false;
        } else if (!skills.equals(other.skills))
            return false;
        return true;
    }

    // if Date is in the list, this day is free
    public boolean isDayFree(Date date) {
            return schedule.isDayAvailable(date);
    }

    public boolean isPeriodHasFreeDay(Date start, Date end) {

        return (0 < getCountFreeDays(start, end)) ? true : false;
    }

    public void markDayFree(Date date) {

        schedule.markDayFree(date);
    }

    public void markDayOff(Date date) {

        schedule.markDayOff(date);
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

    public Set<String> getSkills() {
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
        
        return schedule.countAvailableDaysOfInterval(start, end);
    }
    
    @Override
    public String toString() {
    return new StringBuffer(" Id : ")
    .append(this.id)
    .append(" Name : ")
    .append(this.name)
    .append(" Skills : ")
    .append(this.skills)
    .append(" Schedule : ")
    .append(this.schedule).toString();
    }
}
