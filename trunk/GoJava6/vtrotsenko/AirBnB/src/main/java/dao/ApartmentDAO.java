package dao;

import jdbc.ConnectorDB;
import model.Apartment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by root on 04.11.15.
 */
public class ApartmentDAO implements AbstractDAO<Integer, Apartment> {
    public static final String SQL_SELECT_ALL_APARTMENTS = "SELECT * FROM Apartment";
    public static final String SQL_INSERT = "INSERT INTO Apartment VALUES(?,?,?,?,?,?)";

    private ConnectorDB connectorDB = new ConnectorDB();
    private Connection connection = connectorDB.getConnection();

    public Set<Apartment> findAll() {
        return null;
    }

    public Apartment findEntityById(Integer id) {
        return null;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public boolean delete(Apartment entity) {
        return false;
    }

    public boolean create(Apartment entity) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getsApartmentType());
            preparedStatement.setDate(3, Date.valueOf(entity.getFirstDayAvailable()));
            preparedStatement.setDate(4, Date.valueOf(entity.getLastDayAvailable()));
            preparedStatement.setBoolean(5, entity.isAvailable());
            preparedStatement.setInt(6, entity.getHostId());
            preparedStatement.executeUpdate();

            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    connectorDB.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    public Apartment update(Apartment entity) {
        return null;
    }
}
