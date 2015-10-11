package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.IApartmentDao;
import com.gojava6.airbnb.dao.jdbc.ApartmentDao;
import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.ApartmentType;
import com.gojava6.airbnb.model.User;

import java.util.List;

public class ApartmentService {

    IApartmentDao iApartmentDao;

    public ApartmentService(IApartmentDao iApartmentDao) {
        this.iApartmentDao = iApartmentDao;
    }

    public void createApartment(String city, ApartmentType apartmentType, Integer userId) {
        Apartment apartment = new Apartment();
        apartment.setCity(city);
        apartment.setApartmentType(apartmentType.getApartmentType());
        apartment.setUserId(userId);

        iApartmentDao.createApartment(apartment);
    }

    public void deleteApartment(Apartment apartment) {
        iApartmentDao.deleteApartment(apartment);
    }

    public Apartment getApartment(Integer apartmentId) {
        return iApartmentDao.getApartment(apartmentId);
    }

    public List<Apartment> getApartmentList() {
        return iApartmentDao.getApartmentList();
    }

    public void printAllApartments(){
        List<Apartment> apartmentList = getApartmentList();

        for (Apartment apartment : apartmentList) {
            System.out.println(apartment.toString());
        }
    }

}
