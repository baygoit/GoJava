package freetime;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestTask {
    Task task;
    Employee employee;
    
    @Before
    public void executedBeforeEach() {
         task = new Task();
         task.addSkill("java");
         task.addSkill("spring");
         
         
         employee = new Employee();
         employee.setName("John Doe");
         employee.addSkill("agile");
         employee.addSkill("java");
         employee.addSkill("spring");
         employee.markDayFree(new Date());
         
    }
    
    @Test
    public void testIsEmployeeMatchSkills() throws Exception {
        assertTrue(task.isEmployeeMatchSkills(employee));
        employee.removeSkill("spring");
        assertFalse(task.isEmployeeMatchSkills(employee));
    }

    @Test
    public void testIsEmployeeMatchDates() throws Exception {
        assertTrue(task.isEmployeeMatchDates(employee));
//        employee.markDayOff(new Date());
//        assertFalse(task.isEmployeeMatchDates(employee));
    }

    @Test
    public void testChangeEmployee() throws Exception {
       task.changeEmployee(employee);
       assertSame( task.getCurrentEmployee(), employee);
    }

    @Test
    public void testIsCompleted() {
        assertFalse(task.isCompleted());
    }

}
