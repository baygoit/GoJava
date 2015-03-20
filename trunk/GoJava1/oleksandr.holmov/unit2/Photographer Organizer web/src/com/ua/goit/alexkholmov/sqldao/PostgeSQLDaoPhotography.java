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

import com.ua.goit.alexkholmov.dao.PhotographyDao;
import com.ua.goit.alexkholmov.logic.Photography;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoPhotography implements PhotographyDao {

    private final Connection connection;
    
    public PostgeSQLDaoPhotography(Connection connection) {
        this.connection = connection;
    }
    
    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PhotographyDao#create(com.ua.goit.alexkholmov.logic.Photography)
     */
    @Override
    public Photography create(Photography photography) throws SQLException {
        String sql = "INSERT INTO photography(phot_price, phot_time, phot_info) " +
                     "VALUES (?, ?, ?) RETURNING phot_id;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, photography.getPrice());
        pStatement.setInt(2, photography.getPhotographyTime());
        pStatement.setString(3, photography.getDescription());
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        photography.setPhotographyId(rs.getInt("phot_id"));
        rs.close();
        pStatement.close();
        return photography;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PhotographyDao#read(int)
     */
    @Override
    public Photography read(int id) throws SQLException {
        String sql = "SELECT phot_id, phot_price, phot_time, phot_info " +
                     "FROM photography WHERE phot_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        Photography photography = new Photography();
        photography.setPhotographyId(rs.getInt("phot_id"));
        photography.setPrice(rs.getInt("phot_price"));
        photography.setPhotographyTime(rs.getInt("phot_time"));
        photography.setDescription(rs.getString("phot_info"));
        rs.close();
        pStatement.close();
        return photography;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PhotographyDao#update(com.ua.goit.alexkholmov.logic.Photography)
     */
    @Override
    public void update(Photography photography) throws SQLException {
        String sql = "UPDATE photography SET phot_price=?, phot_time=?, phot_info=? " +
                     "WHERE phot_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, photography.getPrice());
        pStatement.setInt(2, photography.getPhotographyTime());
        pStatement.setString(3, photography.getDescription());
        pStatement.setInt(4, photography.getPhotographyId());
        pStatement.execute();
        pStatement.close();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PhotographyDao#delete(com.ua.goit.alexkholmov.logic.Photography)
     */
    @Override
    public void delete(Photography photography) throws SQLException {
        String sql = "DELETE FROM photography WHERE phot_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, photography.getPhotographyId());
        pStatement.execute();
        pStatement.close();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PhotographyDao#getAll()
     */
    @Override
    public List<Photography> getAll() throws SQLException {
        String sql = "SELECT phot_id, phot_price, phot_time, phot_info " +
                     "FROM photography;";
        List<Photography> list = new ArrayList<Photography>();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()) {
            Photography photography = new Photography();
            photography.setPhotographyId(rs.getInt("phot_id"));
            photography.setPrice(rs.getInt("phot_price"));
            photography.setPhotographyTime(rs.getInt("phot_time"));
            photography.setDescription(rs.getString("phot_info"));
            list.add(photography);
        }
        rs.close();
        pStatement.close();
        return list;
    }

}
