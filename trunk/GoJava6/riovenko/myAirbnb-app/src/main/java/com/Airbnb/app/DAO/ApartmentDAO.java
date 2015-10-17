package com.Airbnb.app.DAO;

import com.Airbnb.app.model.Apartment;
import java.util.List;
/**
 * Created by romanroma on 10.10.15.
 */
public interface ApartmentDAO {
    public void saveApartment(Apartment apartment);
    public void deleteApartment (int id);
    public Apartment getBiId (int id);
    public List<Apartment> getAll();
}
