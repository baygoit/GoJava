package freetime;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public class Task {

    private String description;
    private Date start;
    private int estimateDays;
    private Date end;
    private boolean done;
    private Set<String> skills;
    private Employee currentEmployee;
    //private List<Employee> previousEmployees;
    
    public Task(String description, Date start,  Date end, int estimateDays,
             Set<String> skills) {
        super();
        this.description = description;
        this.start = start;
        this.estimateDays = estimateDays;
        this.end = end;
        this.done = false;
        this.skills = skills;
        this.currentEmployee = null;
        //this.previousEmployees = previousEmployees;
    }

    

    public boolean isEmployeeMatchSkills(Employee employee) throws FreetimeException {

        if (employee == null) {
            throw new FreetimeException();
        }
        boolean matchSkills = true;

        for (String skill : skills) {
            if (!employee.hasSkill(skill)) {
                matchSkills = false;
                break;
            }
        }

        return matchSkills;
    }

    public boolean isEmployeeMatchDates(Employee employee) throws FreetimeException {

        if (employee == null) {
            throw new FreetimeException();
        }

        return (employee.getCountFreeDays(start, end) < estimateDays) ? false
                : true;

    }

    public void changeEmployee(Employee newEmployee) throws FreetimeException {

        if (newEmployee == null) {
            throw new FreetimeException();
        }

        if (currentEmployee.equals(newEmployee)) {
            // throw new Exception();
        } else {
            //previousEmployees.add(currentEmployee);
            currentEmployee = newEmployee;
        }
    }
    
    public void addSkill(String newSkill) {
        String skill = new String(newSkill.toLowerCase());
        skills.add(skill);
    }
    
    public boolean isCompleted() {
        return done;
    }
    
//    public void display() {
//        
//        System.out.println("Description: " +description + " ");
//        System.out.println("Start: " +start + " End: " + end);
//        System.out.println("Estimeted days needed: " + estimateDays);
//        System.out.println("Skills: " + skills);
//        System.out.println("Current Employee: " + currentEmployee);
//    }

    public Employee getCurrentEmployee() throws FreetimeException {
        if (currentEmployee == null) {
            throw new FreetimeException();
        }
        return currentEmployee;
    }
}