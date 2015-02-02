package freetime;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEmployee {
    Employee testEmployee;
    
    @BeforeClass
    public static void onceExecutedBeforeAll() {
        //System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }

    @Before
    public void executedBeforeEach() {
         testEmployee = new Employee("Sergiy", "sergiy", "", "sergiy@gmail.com",
                "***");
    }

    @Test
    public void testSmoke() {
        assertTrue(true);
    }

    @Test
    public void testEmployee() {
        //Employee employee = new Employee();
        assertNotNull(testEmployee);
    }

    @Test
    public void testHasSkill() {
        HashSet<String> skills = new HashSet<String>();
        skills.add("uml");
        skills.add("junit");
        testEmployee.setSkills(skills);
        assertTrue(testEmployee.hasSkill("UML"));
        assertTrue(testEmployee.hasSkill("junit"));
        assertFalse(testEmployee.hasSkill("spring"));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testIsDayFree() {
        testEmployee.markDayFree(new Date());
        assertTrue(testEmployee.isDayFree(new Date()));
        assertFalse(testEmployee.isDayFree(new Date(2015,01,01)));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testIsPeriodHasFreeDay() {
        testEmployee.markDayFree(new Date(2015,01,01));
        Date start = new Date(2015,01,01);
        Date end = new Date(2015,01,02);
        try {
            assertTrue(testEmployee.isPeriodHasFreeDay(start, end));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testMarkDayBusy() {
        testEmployee.markDayBusy(new Date());
        testEmployee.markDayFree(new Date());
        assertTrue(testEmployee.isDayFree(new Date()));
        assertFalse(testEmployee.isDayFree(new Date(2015,01,01)));
    }



    @Test
    public void testAddSkill() {
        testEmployee.addSkill("UML");
        testEmployee.addSkill("JUnit");
        assertTrue(testEmployee.hasSkill("uml"));
        assertTrue(testEmployee.hasSkill("junit"));
        assertFalse(testEmployee.hasSkill("spring"));
    }

    @Test
    public void testRemoveSkill() {
        HashSet<String> skills = new HashSet<String>();
        skills.add("uml");
        skills.add("junit");
        skills.add("spring");
        testEmployee.setSkills(skills);
        testEmployee.removeSkill("spring");
        testEmployee.removeSkill("UML");
        assertFalse(testEmployee.hasSkill("UML"));
        assertTrue(testEmployee.hasSkill("junit"));
        assertFalse(testEmployee.hasSkill("spring"));
    }


}
