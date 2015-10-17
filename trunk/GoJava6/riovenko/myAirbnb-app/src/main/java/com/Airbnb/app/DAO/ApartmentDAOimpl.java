package com.Airbnb.app.DAO;

import com.Airbnb.app.Maps;
import com.Airbnb.app.model.Apartment;

import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public class ApartmentDAOimpl implements ApartmentDAO {

    public void saveApartment(Apartment apartment) {
        Maps.apartments.put(apartment.getId(),apartment);
    }

    public void deleteApartment(int id) {
        Maps.apartments.remove(id);
    }

    public Apartment getBiId(int id) {
        return Maps.apartments.get(id);
    }

    public List<Apartment> getAll() {
        return null;
    }
}
