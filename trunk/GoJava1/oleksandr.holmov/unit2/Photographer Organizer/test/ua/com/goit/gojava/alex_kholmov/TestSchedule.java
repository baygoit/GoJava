/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author SASH
 *
 */
public class TestSchedule {
    private PackageFotos pFotos1 = new PackageFotos("pack1", 250, 15, 10);
    private PackageFotos pFotos2 = new PackageFotos("pack2", 40, 35, 15);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private WorkWithFotos workWithFotos = new WorkWithFotos();
    
    @Before
    public void addPackage() {
        workWithFotos.addPackage(pFotos1);
        workWithFotos.addPackage(pFotos2);
    }
    
    private Schedule schedule = new Schedule();
    
    @Before
    public void addSchedule() throws Exception {
        schedule.setWorkWithFotos(workWithFotos);
        schedule.setDeadline(2015, 2, 4);
        schedule.setStartWork(2015, 1, 13);
        schedule.calcEndWork();
    }
    
    
    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Schedule#getAmountDays()}.
     */
    @Test
    public void testGetAmountDays() {
        //fail("Not yet implemented"); // TODO
        int res = schedule.getAmountDays();
        assertEquals("Error amount days", 24, res);
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Schedule#calcEndWork()}.
     */
    @Test
    public void testCalcEndWork() throws Exception {
        //fail("Not yet implemented"); // TODO
        String res = dateFormat.format(schedule.endWork.getTime());
        assertEquals("Error date", "06.04.2015", res);
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Schedule#isOutOfDeadline()}.
     */
    @Test
    public void testIsOutOfDeadline() {
        //fail("Not yet implemented"); // TODO
        boolean res = schedule.isOutOfDeadline();
        assertTrue(res);
    }

}
