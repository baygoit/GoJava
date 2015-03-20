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

import com.ua.goit.alexkholmov.dao.PackageFotosDao;
import com.ua.goit.alexkholmov.logic.PackageFotos;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoPackageFotos implements PackageFotosDao {

    private final Connection connection;
    
    public PostgeSQLDaoPackageFotos(Connection connection) {
        this.connection = connection;
    }
    
    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PackageFotosDao#create(com.ua.goit.alexkholmov.logic.PackageFotos)
     */
    @Override
    public PackageFotos create(PackageFotos fotos, int orderId) throws SQLException {
        String sql = "INSERT INTO packagefotos(pack_amountfotos, pack_timetoedit, pack_reservetime, pack_info, ord_id) " +
                     "VALUES (?, ?, ?, ?, ?) RETURNING pack_id;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, fotos.getAmountFotos());
        pStatement.setInt(2, fotos.getTimeEditingOneFoto());
        pStatement.setInt(3, fotos.getPercentReserveTime());
        pStatement.setString(4, fotos.getPackageDescription());
        pStatement.setInt(5, orderId);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        fotos.setPackageId(rs.getInt("pack_id"));
        rs.close();
        pStatement.close();
        return fotos;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PackageFotosDao#read(int)
     */
    @Override
    public PackageFotos read(int id) throws SQLException {
        String sql = "SELECT pack_id, pack_amountfotos, pack_timetoedit, pack_reservetime, pack_info, ord_id " +
                     "FROM packagefotos WHERE pack_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        PackageFotos fotos = new PackageFotos();
        fotos.setPackageId(rs.getInt("pack_id"));
        fotos.setAmountFotos(rs.getInt("pack_amountfotos"));
        fotos.setTimeEditingOneFoto(rs.getInt("pack_timetoedit"));
        fotos.setPercentReserveTime(rs.getInt("pack_reservetime"));
        fotos.setPackageDescription(rs.getString("pack_info"));
        rs.close();
        pStatement.close();
        return fotos;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PackageFotosDao#update(com.ua.goit.alexkholmov.logic.PackageFotos)
     */
    @Override
    public void update(PackageFotos fotos) throws SQLException {
        String sql = "UPDATE packagefotos " +
                     "SET pack_amountfotos=?, pack_timetoedit=?, pack_reservetime=?, pack_info=? " +
                     "WHERE pack_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, fotos.getAmountFotos());
        pStatement.setInt(2, fotos.getTimeEditingOneFoto());
        pStatement.setInt(3, fotos.getPercentReserveTime());
        pStatement.setString(4, fotos.getPackageDescription());
        pStatement.setInt(5, fotos.getPackageId());
        pStatement.execute();
        pStatement.close();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PackageFotosDao#delete(com.ua.goit.alexkholmov.logic.PackageFotos)
     */
    @Override
    public void delete(PackageFotos fotos) throws SQLException {
        String sql = "DELETE FROM packagefotos WHERE pack_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, fotos.getPackageId());
        pStatement.execute();
        pStatement.close();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.PackageFotosDao#getAll()
     */
    @Override
    public List<PackageFotos> getAll(int orderId) throws SQLException {
        String sql = "SELECT pack_id, pack_amountfotos, pack_timetoedit, pack_reservetime, pack_info, ord_id " +
                     "FROM packagefotos WHERE ord_id=?;";
        List<PackageFotos> list = new ArrayList<PackageFotos>();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, orderId);
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()) {
            PackageFotos fotos = new PackageFotos();
            fotos.setPackageId(rs.getInt("pack_id"));
            fotos.setAmountFotos(rs.getInt("pack_amountfotos"));
            fotos.setTimeEditingOneFoto(rs.getInt("pack_timetoedit"));
            fotos.setPercentReserveTime(rs.getInt("pack_reservetime"));
            fotos.setPackageDescription(rs.getString("pack_info"));
            list.add(fotos);
        }
        rs.close();
        pStatement.close();
        return list;
    }

}
