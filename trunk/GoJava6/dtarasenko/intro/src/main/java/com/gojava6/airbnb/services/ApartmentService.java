package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.ApartmentDao;
import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.ApartmentType;

import java.util.List;

public class ApartmentService {

    ApartmentDao apartmentDao = new ApartmentDao();

    public void createApartment(String city, ApartmentType apartmentType, Integer userId) {
        apartmentDao.createApartment(city, apartmentType, userId);
    }

    public void deleteApartment(Integer apartmentId) {
        apartmentDao.deleteApartment(apartmentId);
    }

    public List<Apartment> getApartmentList() {
        return (List<Apartment>)(List<?>) apartmentDao.getApartmentList();
    }

    public void printAllApartments(){
        List<Apartment> apartmentList = getApartmentList();

        for (Apartment apartment : apartmentList) {
            System.out.println(apartment.toString());
        }
    }

}
