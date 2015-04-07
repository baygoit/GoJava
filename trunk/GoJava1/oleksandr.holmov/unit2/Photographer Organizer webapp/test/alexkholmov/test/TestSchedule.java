/**
 * 
 */
package alexkholmov.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import alexkholmov.organizer.logic.PackageFotos;
import alexkholmov.organizer.logic.Schedule;
/**
 * @author SASH
 *
 */
public class TestSchedule {
    private PackageFotos pFotos1 = new PackageFotos(250, 15, 10);
    private PackageFotos pFotos2 = new PackageFotos(40, 35, 15);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    private Schedule schedule = new Schedule();

    
    @Before
    public void addSchedule() throws Exception {
        List<PackageFotos> pFotos = new ArrayList<PackageFotos>();
        pFotos.add(pFotos1);
        pFotos.add(pFotos2);        
        schedule.setAllFotos(pFotos);
        schedule.setDeadline(dateFormat.parse("12.03.2015"));
        schedule.setStartWork(dateFormat.parse("23.02.2015"));
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
        String res = dateFormat.format(schedule.getEndWork());
        assertEquals("Error date", "21.03.2015", res);
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
