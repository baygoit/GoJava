package com.vopanasyuk;


        import com.vopanasyuk.dao.DaoDB;
        import com.vopanasyuk.dao.DaoUser;
        import com.vopanasyuk.enums.ApartType;
        import com.vopanasyuk.model.Apartment;
        import com.vopanasyuk.db.AirbnbDB;
        import com.vopanasyuk.model.Organization;
        import com.vopanasyuk.model.User;
        import org.apache.log4j.Logger;
        import java.sql.SQLException;
/**
 * Created by Hunky on 05.11.2015.
 */

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

        DaoDB db = new AirbnbDB();
        DaoUser dao = new DaoUser(db.getConnection());
        User user = null;
        try {
            user = dao.getById(1);
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