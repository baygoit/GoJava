package com.azuiev;

import com.azuiev.dao.DBDao;
import com.azuiev.dao.UserDao;
import com.azuiev.db.AirbnbDBDao;
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

        DBDao db = new AirbnbDBDao();
        UserDao dao = new UserDao(db.getConnection());
        User user = null;
        try {
            user = dao.getById(new Long(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sportLife.register(user);

        Apartment book1 = user.registerBook("Kiev", "Lenina 1", ApartType.APARTAMENT);
        Apartment book2 = user.registerBook("Moskva", "Pushkina 1", ApartType.PLACE);

        System.out.println(user);
        ApartType t = ApartType.values()[0];
        System.out.println(t);
    }
}
