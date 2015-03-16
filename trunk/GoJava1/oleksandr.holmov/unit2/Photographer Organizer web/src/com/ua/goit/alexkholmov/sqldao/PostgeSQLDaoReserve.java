/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ua.goit.alexkholmov.dao.ReserveDao;
import com.ua.goit.alexkholmov.logic.FotoStudio;
import com.ua.goit.alexkholmov.logic.Reserve;
import com.ua.goit.alexkholmov.logic.ReserveList;

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
        rs.close();
        pStatement.close();
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
        Reserve reserve = new Reserve();
        reserve.setReserveId(rs.getInt("res_id"));
        reserve.setReserveDate(rs.getDate("res_date"));
        reserve.setWorkTime(rs.getString("work_time"));
        rs.close();
        pStatement.close();
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
        pStatement.close();
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
        pStatement.close();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.ReserveDao#getAll()
     */
    @Override
    public List<Reserve> getAll(int studioId) throws SQLException {
        String sql = "SELECT res_id, res_date, work_time, stud_id  FROM reserve "
                     + "WHERE sud_id=?;";
        List<Reserve> list = new ArrayList<Reserve>();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, studioId);
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()) {
            Reserve reserve = new Reserve();
            reserve.setReserveId(rs.getInt("res_id"));
            reserve.setReserveDate(rs.getDate("res_date"));
            reserve.setWorkTime(rs.getString("work_time"));
            list.add(reserve);
        }
        rs.close();
        pStatement.close();
        return list;
    }

    @Override
    public void createFromList(ReserveList reserveList, int studioId) throws SQLException {
        String sql = "INSERT INTO reserve(res_date, work_time, stud_id) " +
                     "VALUES (?, ?, ?);";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        List<Reserve> reserves = reserveList.getReservs();
        for (Reserve reserve : reserves) {
            pStatement.setDate(1, new Date(reserve.getReserveDate().getTime()));
            pStatement.setString(2, reserve.getWorkTime());
            pStatement.setInt(3, studioId);
            pStatement.execute();
        }
        pStatement.close();
    }

}
