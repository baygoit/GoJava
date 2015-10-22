package com.Airbnb.app.DAO;

import com.Airbnb.app.model.Apartment;
import com.Airbnb.app.model.ApartType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by romanroma on 10.10.15.
 */
public interface ApartmentDAO {
    public void addApartment(Apartment apartment) throws SQLException;
    public void deleteApartment (int id) throws SQLException;
    public Apartment getApartmentById (int id) throws SQLException;
    public int checkUniqueCity (String city) throws SQLException;
    public int addUniqueCity (String city) throws SQLException;
    public int getCityId (String City) throws SQLException;
    public int getApartmentTypeId (ApartType apartmentType) throws SQLException;
    public List<Apartment> getAllApartment () throws SQLException;
    //public ArrayList<Integer> getPossibleApartment (String city, ApartType apartType) throws SQLException;
}
