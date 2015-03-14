/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.dao.ReserveDao;
import com.ua.goit.alexkholmov.logic.Reserve;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoReserve implements ReserveDao {
    
    private final Connection connection;
    
    public PostgeSQLDaoReserve(Connection connection) {
        this.connection = connection;
    }
    
    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ReserveDao#create()
     */
    @Override
    public Reserve create(Reserve reserve, int studioId) throws SQLException {
        String sql = "INSERT INTO reserve(res_date, work_time, stud_id) " +
                     "VALUES (?, ?, ?) RETURNING res_id;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setDate(1, new Date(reserve.getReserveDate().getTime()));
        pStatement.setString(2, reserve.getWorkTime());
        pStatement.setInt(3, studioId);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        reserve.setReserveId(rs.getInt("res_id"));
        return reserve;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ReserveDao#read(int)
     */
    @Override
    public Reserve read(int id) throws SQLException {
        String sql = "SELECT res_id, res_date, work_time, stud_id FROM reserve "
                    + "WHERE res_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        Reserve reserve = new Reserve(rs);
        return reserve;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ReserveDao#update(com.ua.goit.alexkholmov.logic.Reserve)
     */
    @Override
    public void update(Reserve reserve) throws SQLException {
        String sql = "UPDATE reserve " 
                     + "SET res_date=?, work_time=?, stud_id=? "
                     + "WHERE res_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setDate(1, new Date(reserve.getReserveDate().getTime()));
        pStatement.setString(2, reserve.getWorkTime());
        pStatement.execute();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ReserveDao#delete(com.ua.goit.alexkholmov.logic.Reserve)
     */
    @Override
    public void delete(Reserve reserve) throws SQLException {
        String sql = "DELETE FROM reserve WHERE res_id=?";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, reserve.getReserveId());
        pStatement.execute();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ReserveDao#getAll()
     */
    @Override
    public List<Reserve> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
