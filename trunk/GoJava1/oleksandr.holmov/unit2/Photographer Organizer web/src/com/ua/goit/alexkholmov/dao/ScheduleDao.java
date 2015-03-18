/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.Schedule;

/**
 * @author SASH
 *
 */
public interface ScheduleDao {

    public Schedule create(Schedule schedule) throws SQLException;
    
    public Schedule read(int id) throws SQLException;
    
    public void update(Schedule schedule) throws SQLException;
    
    public void delete(Schedule schedule) throws SQLException;
    
    public List<Schedule> getAll() throws SQLException;
}
