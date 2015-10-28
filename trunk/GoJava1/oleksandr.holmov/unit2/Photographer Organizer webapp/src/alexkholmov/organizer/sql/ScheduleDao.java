/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.Schedule;
import alexkholmov.organizer.sql.GenericDaoImpl;

/**
 * @author SASH
 *
 */
public class ScheduleDao extends GenericDaoImpl<Schedule, Integer> {

    public ScheduleDao() {
        super(Schedule.class);
    }
}
