package com.azuiev;

import com.azuiev.dao.UserDao;
import com.azuiev.enums.ApartType;
import com.azuiev.model.Apartment;
import com.azuiev.model.Organization;
import com.azuiev.model.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class AirBnB {

    public static final Logger log = Logger.getLogger(AirBnB.class);
    public static Organization sportLife = new Organization();

    public static void main(String[] args) {

        log.trace("AIRBNB project");

        if (sportLife!=null){
            log.info("Organization successfully created");
        } else {
            log.error("Organization creating failed");
        }

     }
}
