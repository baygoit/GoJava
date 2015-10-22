package com.airbnb.services;

import com.airbnb.dao.IApartmentDao;
import com.airbnb.model.Apartment;
import com.airbnb.model.User;

import java.util.List;

/**
 * Created by Игорь on 16.10.2015.
 */
public class ApartamentService {
    private IApartmentDao iApartmentDao;

    public ApartamentService(IApartmentDao iApartmentDao) {
        this.iApartmentDao = iApartmentDao;
    }

    public List<Apartment> getAllApartments(){
        return iApartmentDao.getApartmentList();
    }

    public Apartment getApartamentById(int idApartament){
        return iApartmentDao.getApartment(idApartament);
    }

    public void deleteApartament(int idApartament){
        iApartmentDao.delete(idApartament);
    }

    public void registerApartament(Apartment apartment){
        iApartmentDao.addToDb(apartment);
    }

    public boolean isAvailable(int idApartament){
        return true;
    }

    public void printApartaments(){
        List<Apartment> apartments = iApartmentDao.getApartmentList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment.toString());
        }
    }
}
