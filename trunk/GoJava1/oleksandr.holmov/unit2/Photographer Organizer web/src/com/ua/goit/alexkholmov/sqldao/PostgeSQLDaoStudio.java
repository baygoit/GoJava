/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ua.goit.alexkholmov.dao.StudioDao;
import com.ua.goit.alexkholmov.logic.FotoStudio;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoStudio implements StudioDao {
    
    private final Connection connection;
    
    public PostgeSQLDaoStudio(Connection connection) {
        this.connection = connection;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.StudioDao#create()
     */
    @Override
    public FotoStudio create(FotoStudio studio) throws SQLException {
        String sql = "INSERT INTO studio(stud_name, stud_address, stud_phone, stud_info) " +
                     "VALUES (?, ?, ?, ?) RETURNING stud_id;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, studio.getName());
        pStatement.setString(2, studio.getAddress());
        pStatement.setString(3, studio.getPhone());
        pStatement.setString(4, studio.getAdditionalInfo());
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        studio.setStudioId(rs.getInt("stud_id"));
        return studio;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.StudioDao#read(int)
     */
    @Override
    public FotoStudio read(int id) throws SQLException {
        String sql = "SELECT stud_id, stud_name, stud_address, stud_phone, stud_info "
                + "FROM studio " + "WHERE stud_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        FotoStudio studio = new FotoStudio(rs);
        return studio;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.StudioDao#update(com.ua.goit.alexkholmov.logic.FotoStudio)
     */
    @Override
    public void update(FotoStudio studio) throws SQLException {
        String sql = "UPDATE studio "
                + "SET stud_name=?, stud_address=?, stud_phone=?, stud_info=? "
                + "WHERE stud_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, studio.getName());
        pStatement.setString(2, studio.getAddress());
        pStatement.setString(3, studio.getPhone());
        pStatement.setString(4, studio.getAdditionalInfo());
        pStatement.setInt(5, studio.getStudioId());
        pStatement.execute();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.StudioDao#delete(com.ua.goit.alexkholmov.logic.FotoStudio)
     */
    @Override
    public void delete(FotoStudio studio) throws SQLException {
        String sql = "DELETE FROM studio WHERE stud_id = ?";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, studio.getStudioId());
        pStatement.execute();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.StudioDao#getAll()
     */
    @Override
    public List<FotoStudio> getAll() throws SQLException {
        String sql = "SELECT stud_id, stud_name, stud_address, stud_phone, stud_info FROM studio;";
        List<FotoStudio> list = new ArrayList<FotoStudio>();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()) {
            FotoStudio studio = new FotoStudio(rs);
            list.add(studio);
        }
        return list;
    }

}
