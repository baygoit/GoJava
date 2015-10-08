package com.azuiev;

import com.azuiev.DAO.DaoDB;
import com.azuiev.DAO.DaoUser;
import com.azuiev.Enums.ApartType;
import com.azuiev.model.Apartment;
import com.azuiev.DB.DBAirBnB;
import com.azuiev.model.Organization;
import com.azuiev.model.User;
import com.azuiev.Enums.UserRoles;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

        DaoDB db = new DBAirBnB();
        DaoUser dao = new DaoUser(db.getConnection());
        User user = null;
        try {
            user = dao.read(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sportLife.register(user);

        Apartment book1 = user.registerBook("Kiev", "Lenina 1", ApartType.APARTAMENT);
        Apartment book2 = user.registerBook("Moskva", "Pushkina 1", ApartType.PLACE);

        System.out.println(user);

    }
}
