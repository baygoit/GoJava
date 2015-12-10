package com.airbnb.dao;

import com.airbnb.model.Apartment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by Игорь on 11.10.2015.
 */

public interface IApartmentDao {
    List<Apartment> getApartmentList();
//    List<Apartment> getApartmentListByIdUser(int idUser);
    Apartment getApartment(int id);
//    Set<String> getCitySet();
    void delete(int id);
    void addToDb(Apartment apartment);
}
