/**
 * 
 */
package ua.com.goit.alexkholmov.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import com.ua.goit.alexkholmov.logic.*;
/**
 * @author SASH
 *
 */
public class TestSchedule {
    private PackageFotos pFotos1 = new PackageFotos("pack1", 250, 15, 10, 1);
    private PackageFotos pFotos2 = new PackageFotos("pack2", 40, 35, 15, 2);
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
        schedule.setDeadline("22.03.2015");
        schedule.setStartWork("02.03.2015");
        schedule.calcEndWork();
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Schedule#getAmountDays()}.
     */
    @Test
    public void testGetAmountDays() {
        int res = schedule.getAmountDays();
        assertEquals("Error amount days", 26, res);
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Schedule#calcEndWork()}.
     */
    @Test
    public void testCalcEndWork() throws Exception {
        String res = dateFormat.format(schedule.endWork.getTime());
        assertEquals("Error date", "28.03.2015", res);
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Schedule#isOutOfDeadline()}.
     */
    @Test
    public void testIsOutOfDeadline() {
        boolean res = schedule.isOutOfDeadline();
        assertTrue(res);
    }

}
