package freetime;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEmployee {
    
    Employee testEmployee0;
    Employee testEmployee1;
    Employee testEmployee2;
    Employee testEmployee3;
    HashSet<String> skills;
    Date freeDay1;
    Date freeDay2;
    Date busyDay1;
    Date busyDay2;
    Date notMarkedDay;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        // System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }

    @Before
    public void executedBeforeEach() {
        testEmployee0 = new Employee(0, "Employee Zero", "");
        testEmployee1 = new Employee(1, "Employee One", "java,uml,swing,agile");
        testEmployee2 = new Employee(2, "Employee Two", "java,agile");
        testEmployee3 = new Employee(3, "Employee Three", "java,uml");
        skills = new HashSet<String>();
        skills.add("java");
        
        freeDay1 = new Date(2015, 02, 16);
        freeDay2 = new Date(2015, 02, 17);
        busyDay1 = new Date(2015, 02, 21);
        busyDay2 = new Date(2015, 02, 22);
        notMarkedDay = new Date(2015, 02, 19);
    }

    @Test
    public void testSmoke() {
        assertTrue(true);
    }

    @Test
    public void testEmployee() {
        assertNotNull(testEmployee0);
    }

    @Test
    public void testHasSkill() {
        
        assertFalse(testEmployee0.hasSkill("UML"));
        assertTrue(testEmployee1.hasSkill("java"));
        assertTrue(testEmployee2.hasSkill("Agile"));
    }

    @Test
    public void testIsDayFree() {
        //testEmployee0.
        assertFalse(testEmployee0.isDayFree(new Date()));
        // assertFalse(testEmployee.isDayFree(new Date(2015,01,01)));
    }
    
    @Test
    public void testMarkDayBusy() {
        // testEmployee.markDayBusy(new Date());
        // testEmployee.markDayFree(new Date());
        // assertTrue(testEmployee.isDayFree(new Date()));
        assertFalse(testEmployee0.isDayFree(new Date(2015, 01, 01)));
    }

    @Test
    public void testGetCountOfFreeDays() {
     
        testEmployee0.markDayFree(freeDay1);
        testEmployee0.markDayFree(freeDay2);
        testEmployee0.markDayFree(notMarkedDay);
        assertTrue(2 == testEmployee0.getCountFreeDays(freeDay1, freeDay2));
        assertTrue(1 == testEmployee0.getCountFreeDays(freeDay2, freeDay2));
        assertTrue(3 == testEmployee0.getCountFreeDays(freeDay1, busyDay2));
    }

    @Test
    public void testIsPeriodHasFreeDay() {
        testEmployee0.markDayFree(freeDay1);
        testEmployee0.markDayFree(freeDay2);
       assertTrue(testEmployee0.isPeriodHasFreeDay(freeDay1,busyDay2));
    }


    @Test
    public void testAddSkill() {
        testEmployee0.addSkill("JUnit");
        assertTrue(testEmployee0.hasSkill("junit"));
        assertFalse(testEmployee0.hasSkill("struts"));
    }

    @Test
    public void testRemoveSkill() {
        assertTrue(testEmployee1.hasSkill("UML"));
        testEmployee1.removeSkill("UML");
        assertFalse(testEmployee1.hasSkill("UML"));
    }

}
