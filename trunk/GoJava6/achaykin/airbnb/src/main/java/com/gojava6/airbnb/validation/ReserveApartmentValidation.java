package com.gojava6.airbnb.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * @Autor Andrey Chaykin
 * @Since 05.12.2015
 */
public class ReserveApartmentValidation {

    private static Logger LOGGER = LogManager.getLogger(ReserveApartmentValidation.class);

    //todo should i create new class for two methods if i can creats this methods in service class?
    //todo (package com.gojava6.airbnb.service.daoservice; (checkOrdersDays() and checkArguments()


//    public static boolean checkArguments(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {
//        if (apartmentID != 0 && hostID != 0 && renterID != 0 && checkIN != null && checkOUT != null) {
//            if (checkOrderDays(checkIN, checkOUT)) {
//
//            } else {
//                LOGGER.error("Incorrect values for reservation! ApartmentID: " + apartmentID +
//                        ", hostID: " + hostID + ", renterID: " + renterID + ", checkIN: " + checkIN +
//                        ", checkOUT: " + checkOUT);
//            }
//        }
//    }
//
//    private static boolean checkOrderDays(Date checkIN, Date checkOUT) {
//        if (checkIN.before(checkOUT)) {
//            return true;
//        } else return false;
//    }
}
