package com.Airbnb.app.DAO;

import com.Airbnb.app.model.Apartment;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by romanroma on 10.10.15.
 */
public interface ApartmentDAO {
    public void addApartment(Apartment apartment) throws SQLException;
    public void deleteApartment (int id) throws SQLException;
    public Apartment getBiId (int id) throws SQLException;
    public List<Apartment> getAll() throws SQLException;
}
