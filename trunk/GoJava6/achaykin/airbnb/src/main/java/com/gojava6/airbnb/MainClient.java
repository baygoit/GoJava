package com.gojava6.airbnb;

import com.gojava6.airbnb.administration.AdministrativeManager;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ReservedApartment;
import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.dao.reservedapartment.MySqlReservedApartmentDAO;
import com.gojava6.airbnb.dao.userdao.MySqlUserDao;
import com.gojava6.airbnb.user.Host;
import com.gojava6.airbnb.user.Renter;
import com.gojava6.airbnb.user.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.gojava6.airbnb.util.ParseDateUtil.parseDate;

public class MainClient {

    public static void main(String[] args) {

        AdministrativeManager administration = new AdministrativeManager();
        MySqlUserDao mySqlUserDao = new MySqlUserDao();
        MySqlApartmentDao mySqlApartmentDao = new MySqlApartmentDao();
        MySqlReservedApartmentDAO mySqlReservedApartmentDAO = new MySqlReservedApartmentDAO();

        Apartment apartment = mySqlApartmentDao.retrieveByID(1);
        Apartment apartment2 = mySqlApartmentDao.retrieveByID(2);
        Apartment apartment3 = mySqlApartmentDao.retrieveByID(3);
        Apartment apartment4 = mySqlApartmentDao.retrieveByID(4);

        Host host = (Host) mySqlUserDao.retrieveById(1);
        Host host1 = (Host) mySqlUserDao.retrieveById(2);
        Renter renter = (Renter) mySqlUserDao.retrieveById(5);
        Renter renter1 = (Renter) mySqlUserDao.retrieveById(6);
        User user = mySqlUserDao.retrieveById(3);
        User user1 = mySqlUserDao.retrieveById(4);


        SimpleDateFormat smdft = new SimpleDateFormat("yyyy/MM/dd");
        Date checkIN = parseDate("2222/01/05");
        Date checkOUT = parseDate("2226/01/10");
        Date checkIN1 = parseDate("1975/01/01");
        Date checkOUT1 = parseDate("1976/01/01");
        Date checkIN2 = null;
        Date checkOUT2 = null;
//        try {
//            checkIN = smdft.parse("10/10/2010");
//            checkOUT = smdft.parse("12/10/2010");
//            checkIN1 = smdft.parse("10/10/2010");
//            checkOUT1 = smdft.parse("12/10/2010");
//            checkIN2 = smdft.parse("10/10/2010");
//            checkOUT2 = smdft.parse("12/10/2010");
//
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        mySqlReservedApartmentDAO.create(
//                apartment.getApartmentID(), host.getUserId(), renter.getUserId(), checkIN, checkOUT);

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//
//
//        try {
//            Date date = simpleDateFormat.parse(checkIN.toString());
//            System.out.println(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//ReservedApartment reservedApartment = mySqlReservedApartmentDAO.retrieveApartmentByID(5);
//        System.out.println(reservedApartment);

//        List<ReservedApartment> reservedApartments = mySqlReservedApartmentDAO.retrieveAoartmentsByHostID(3);
//        System.out.println(reservedApartments.size());
//        for (ReservedApartment reservedApartment : reservedApartments) {
//            System.out.println(reservedApartment);
//        }

//        mySqlReservedApartmentDAO.update(1, 1, 5, checkIN, checkOUT, checkIN1, checkOUT1);

//        mySqlReservedApartmentDAO.delete(1, 1, 5, checkIN1, checkOUT1);

    }
}
