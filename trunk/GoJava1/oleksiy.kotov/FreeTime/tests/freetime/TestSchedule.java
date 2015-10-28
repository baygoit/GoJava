package freetime;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSchedule {
    Schedule schedule;
    Date freeDay1;
    Date freeDay2;
    Date busyDay1;
    Date busyDay2;
    Date notMarkedDay;

    @Before
    public void executedBeforeEach() {
        freeDay1 = new Date(2015, 02, 16);
        freeDay2 = new Date(2015, 02, 17);
        busyDay1 = new Date(2015, 02, 21);
        busyDay2 = new Date(2015, 02, 22);
        notMarkedDay = new Date(2015, 02, 19);

        schedule = new Schedule();
        schedule.markDayFree(freeDay1);
        schedule.markDayFree(freeDay2);
        schedule.markDayOff(busyDay1);
        schedule.markDayOff(busyDay2);
    }

    @Test
    public void testIsDayAvailable() {
        assertTrue(schedule.isDayAvailable(freeDay1));
        assertFalse(schedule.isDayAvailable(busyDay1));
        assertFalse(schedule.isDayAvailable(notMarkedDay));
    }

    @Test
    public void testMarkDayFree() {
        assertFalse(schedule.isDayAvailable(notMarkedDay));
        schedule.markDayFree(notMarkedDay);
        assertTrue(schedule.isDayAvailable(notMarkedDay));
        schedule.markDayFree(busyDay2);
        assertTrue(schedule.isDayAvailable(busyDay2));
    }

    @Test
    public void testMarkDayOff() {
        schedule.markDayOff(notMarkedDay);
        assertFalse(schedule.isDayAvailable(notMarkedDay));
        schedule.markDayOff(freeDay2);
        assertFalse(schedule.isDayAvailable(freeDay2));
    }

    @Test
    public void testCountAvailableDaysOfInterval() {
        int count = schedule.countAvailableDaysOfInterval(freeDay1, busyDay2);
        assertTrue(count == 2);
        count = schedule.countAvailableDaysOfInterval(notMarkedDay, busyDay2);
        assertTrue(count == 0);
    }

}
