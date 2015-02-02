package freetime;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Project {
    
    private String codename;
    private Date start;
    private Date end;
    private Set<String> skills;
    private Map<Employee, SortedSet<Date>> utilization;
    private Manager manager;
    
    public Project(String codename, Date start, Date end, Manager manager) {
        this();
        this.codename = codename;
        this.start = start;
        this.end = end;
        this.manager = manager;
        
    }

    
    Project(){
        this.codename = "noname";
        this.start = new Date();
        this.end = new Date();
        this.skills = new HashSet<String>();
        this.utilization = new HashMap<Employee, SortedSet<Date>>();
    }
    
    public void addEmployee(Employee employee, SortedSet<Date> dates) {
        
        if (employee == null) {
           System.out.println("employee = NULL ");
           return;
        }
        if (dates == null) {
            System.out.println("dates = NULL ");
            return;
        }
        
        if (!utilization.containsKey(employee)) {
            utilization.put(employee, dates);
        } else {
            SortedSet<Date> tmp = utilization.get(employee);
            tmp.addAll(dates);
            utilization.put(employee, tmp);
        }
        
        employee.markDayBusy(dates);
        
    }

}
