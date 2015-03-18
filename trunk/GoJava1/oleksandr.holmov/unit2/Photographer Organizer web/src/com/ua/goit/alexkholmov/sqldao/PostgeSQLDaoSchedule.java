/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.dao.ScheduleDao;
import com.ua.goit.alexkholmov.logic.Schedule;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoSchedule implements ScheduleDao {

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ScheduleDao#create(com.ua.goit.alexkholmov.logic.Schedule)
     */
    @Override
    public Schedule create(Schedule schedule) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ScheduleDao#read(int)
     */
    @Override
    public Schedule read(int id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ScheduleDao#update(com.ua.goit.alexkholmov.logic.Schedule)
     */
    @Override
    public void update(Schedule schedule) throws SQLException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ScheduleDao#delete(com.ua.goit.alexkholmov.logic.Schedule)
     */
    @Override
    public void delete(Schedule schedule) throws SQLException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ScheduleDao#getAll()
     */
    @Override
    public List<Schedule> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
