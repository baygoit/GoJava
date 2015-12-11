package com.gojava6.airbnb;

import com.gojava6.airbnb.administration.AdministrativeManager;
import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.dao.daofactory.MySqlDAOFactory;
import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.dao.reservedapartment.MySqlReservedApartmentDAO;
import com.gojava6.airbnb.dao.userdao.MySqlUserDao;
import com.gojava6.airbnb.model.apartment.ApartmentType;
import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.model.user.User;
import com.gojava6.airbnb.service.daoservice.ApartmentService;
import com.gojava6.airbnb.service.daoservice.ReserveApartmentService;
import com.gojava6.airbnb.service.daoservice.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.gojava6.airbnb.util.ParseDateUtil.parseDate;

public class MainClient {

    public static void main(String[] args) {

        ApartmentService apartmentService = new ApartmentService();
        ReserveApartmentService reservedService = new ReserveApartmentService();
        Apartment apartment = new Apartment(ApartmentType.ENTIRE_APARTMENT, CityType.LONDON, "best street 5", 1);
        apartment.setApartmentID(9);
        Apartment apartment2 = apartmentService.retrieveByID(2);
        Apartment apartment3 = apartmentService.retrieveByID(3);
        Apartment apartment4 = apartmentService.retrieveByID(4);

        Date checkIN = parseDate("2222/01/05");
        Date checkOUT = parseDate("2226/01/10");
        Date checkIN1 = parseDate("1975/01/01");
        Date checkOUT1 = parseDate("1976/01/01");

        SimpleDateFormat smdft = new SimpleDateFormat("yyyy/MM/dd");
        Date checkIN2 = null;
        Date checkOUT2 = null;
        try {
            checkIN = smdft.parse("10/10/2010");
            checkOUT = smdft.parse("12/10/2010");
            checkIN1 = smdft.parse("10/10/2010");
            checkOUT1 = smdft.parse("12/10/2010");
            checkIN2 = smdft.parse("10/10/2010");
            checkOUT2 = smdft.parse("12/10/2010");


        } catch (ParseException e) {
            e.printStackTrace();
        }











        System.out.println("FIHISH");


    }
}
