package com.airbnb.services;

import com.airbnb.dao.IApartmentDao;
import com.airbnb.model.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Игорь on 16.10.2015.
 */
@Component
public class ApartamentService {

    @Autowired
    IApartmentDao iApartmentDao;

    public ApartamentService() {}

    public ApartamentService(IApartmentDao iApartmentDao) {
        this.iApartmentDao = iApartmentDao;
    }

    public List<Apartment> getAllApartments(){
        return iApartmentDao.getApartmentList();
    }

//    public List<Apartment> getApartamentsByIdUser(int idUser){
//        return iApartmentDao.getApartmentListByIdUser(idUser);
//    }

    public Apartment getApartamentById(int idApartament){
        return iApartmentDao.getApartment(idApartament);
    }

    public void deleteApartament(int idApartament){
        iApartmentDao.delete(idApartament);
    }

    public void registerApartament(Apartment apartment){
        iApartmentDao.addToDb(apartment);
    }

    public boolean isAvailable(ReservationDatesService reservationDatesService, int idApartment, Date dateStart, Date dateFinish) {
        return reservationDatesService.isAvailableApartment(idApartment, dateStart, dateFinish);
    }

    public void printApartaments(){
        List<Apartment> apartments = iApartmentDao.getApartmentList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment.toString());
        }
    }

//    public void printApartamentsByIdUser(int idUser){
//        List<Apartment> apartments = iApartmentDao.getApartmentListByIdUser(idUser);
//        for (Apartment apartment : apartments) {
//            System.out.println(apartment.toString());
//        }
//    }

    public Set<String> getCitiesSet(){
        List<Apartment> apartments = getAllApartments();
        Set<String> cities = new HashSet<>();
        for (Apartment apartment : apartments) {
            String city = apartment.getCity();
            cities.add(city);
        }
        return cities;
    }
}
