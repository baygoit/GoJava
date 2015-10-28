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
    private Set<Task> tasks;
    
    Project(Manager manager){
        this.codename = "N/A";
        this.description = "N/A";
        this.start = new Date();
        this.end = new Date();
        this.manager = manager;
        this.tasks = new HashSet<Task>();
    }
    
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
    
    public void changeDeadline(Date newDeadline) {
        //TODO - check all tasks. If some of them out of new deadline 
        // throw exception
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
