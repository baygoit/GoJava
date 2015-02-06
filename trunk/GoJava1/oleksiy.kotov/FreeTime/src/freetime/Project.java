package freetime;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Project {
    
    private String codename;
    private String description;
    private Date start;
    private Date end;
    private Manager manager;
    private List<Task> tasks;
    
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
    }
    
//    public void addEmployee(Employee employee, SortedSet<Date> dates) {
//        
//        if (employee == null) {
//           System.out.println("employee = NULL ");
//           return;
//        }
//        if (dates == null) {
//            System.out.println("dates = NULL ");
//            return;
//        }
//        
//        if (!utilization.containsKey(employee)) {
//            utilization.put(employee, dates);
//        } else {
//            SortedSet<Date> tmp = utilization.get(employee);
//            tmp.addAll(dates);
//            utilization.put(employee, tmp);
//        }
//        
//        employee.markDayBusy(dates);
//        
//    }

}
