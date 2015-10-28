package freetime;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDayStatus {
    DayStatus dayStatus;
    
    @Before
    public void executedBeforeEach() {
         dayStatus = new DayStatus();
    }

    @Test
    public void testIsAvailable() throws FreetimeException {
        dayStatus.setDayoff(true);
        assertFalse(dayStatus.isAvailable());
        dayStatus.setDayoff(false);
        assertTrue(dayStatus.isAvailable());
        dayStatus.setWorkloadPercent(100);
        assertFalse(dayStatus.isAvailable());
    }
    
    @Test(expected=FreetimeException.class)
    public void testsetWorkloadPercentAbove100() throws FreetimeException {
        dayStatus.setWorkloadPercent(101);
    }
    @Test(expected=FreetimeException.class)
    public void testsetWorkloadPercentLessZero() throws FreetimeException {
        dayStatus.setWorkloadPercent(-1);
    }
}
