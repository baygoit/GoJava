package freetime;

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
    private List<Employee> previousEmployees;

    public boolean isEmployeeMatchSkills(Employee employee) throws Exception {

        if (employee == null) {
            throw new Exception();
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

    public boolean isEmployeeMatchDates(Employee employee) throws Exception {

        if (employee == null) {
            throw new Exception();
        }

        return (employee.getCountFreeDays(start, end) < estimateDays) ? false
                : true;

    }

    public void changeEmployee(Employee newEmployee) throws Exception {

        if (newEmployee == null) {
            throw new Exception();
        }

        if (currentEmployee.equals(newEmployee)) {
            // throw new Exception();
        } else {
            previousEmployees.add(currentEmployee);
            currentEmployee = newEmployee;
        }
    }
    
    public boolean isCompleted() {
        return done;
    }
    
    public void display() {
        
        System.out.println("Description: " +description + " ");
        System.out.println("Start: " +start + " End: " + end);
        System.out.println("Estimeted days needed: " + estimateDays);
        System.out.println("Skills: " + skills);
        System.out.println("Current Employee: " + currentEmployee);
    }
}