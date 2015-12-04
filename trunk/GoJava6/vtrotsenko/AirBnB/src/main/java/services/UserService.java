package services;

import dao.UserDAO;
import model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

import static validation.Validation.*;

/**
 * Created by root on 04.11.15.
 */
public class UserService {

    /*UserDAO userDAO = new UserDAO();*/
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User registerUser(User user) {
        if (isValidName(user.getName()) &&
                isValidName(user.getLastname()) &&
                isValidEmail(user.getEmail()))
            entityManager.persist(user);
        return user;
    }

    /*public User login(String email, String password) {
        List<User> users  = userDAO.findAll();
        for (Iterator iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            if (user.getPassword().equals(password) && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }*/

    /*public void becomeHost(User user, String city, Integer idApartment, ApartmentType apartmentType,
                           LocalDate start, LocalDate end) {

        if (isRegisteredAsClient() &&
                isValidName(city) &&
                isValidApartmentType(apartmentType) &&
                isValidDate(start, end)) {
            setUserType(UserType.HOST);
            setIsRegisteredAsHost(true);
            setCity(city);
            Apartment apartment = new Apartment(idApartment, apartmentType, start, end);
            //addApartment(apartment);
            //aS.addCity(this);
            Log.logger.info(" -- " + getName() + " " + getLastname() + " became HOST!");
        }

        else {
            Log.logger.info(" -- " + getName() + " " + getLastname() + " FAILED becoming HOST :(");
        }
    }*/


    /*public void registerApartment(ApartmentDAO apartmentDao, User user, Integer idApartment,
                                  ApartmentType apartmentType, LocalDate start, LocalDate end) {

        Apartment apartment = new Apartment(idApartment, apartmentType, start, end, user.getId());
        //addApartment(apartment);4
        apartmentDao.create(apartment);

    }*/

}
