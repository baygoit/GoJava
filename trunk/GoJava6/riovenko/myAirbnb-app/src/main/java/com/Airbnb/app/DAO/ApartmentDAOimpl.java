package com.Airbnb.app.DAO;

import com.Airbnb.app.Maps;
import com.Airbnb.app.jdbc.DBConnection;
import com.Airbnb.app.model.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public class ApartmentDAOimpl implements ApartmentDAO {

    private static final String addApartmentQuery = "INSERT INTO apartment VALUES (null, ?, ?, ?)";
    private static final String deleteApartmentQuery = "DELETE FROM apartment WHERE id = ?";
    private static final String getApartmentbyIdQuery = "Select id, userId, cityId, apartmentType FROM apartment WHERE id = ?";

    public void addApartment(Apartment apartment) throws SQLException{
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(addApartmentQuery);
            psttmnt.setInt(1, apartment.getHost());
            psttmnt.setInt(2, apartment.getCity());
            psttmnt.setInt(3, apartment.getApartTypeId(apartment.getApartType()));
            psttmnt.executeUpdate();
        }
    }

    public void deleteApartment(int id)throws SQLException{
        Maps.apartments.remove(id);
    }

    public Apartment getBiId(int id) throws SQLException{
        return Maps.apartments.get(id);
    }

    public List<Apartment> getAll()throws SQLException{
        return null;
    }
}
