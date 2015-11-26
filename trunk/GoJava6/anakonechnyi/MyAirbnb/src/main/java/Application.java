
import models.ApartmentType;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.InputMismatchException;

/**
 * @autor A_Nakonechnyi
 * @date 19.09.2015.
 */
public class Application {
    public void register (User user){
        System.out.println("Register");

        System.out.println("");
    }

    public static void main(String[] args) {
        /*try {
            User host = new User("Tony", "Host1", "booble@goom");
            //host.setCity("Kyiv");
            host.setNewApartments("PLASE");
            *//*switch (host.apartmentType.PLACE) {
                case PLACE:
                    host.switchedApartType="Place";
                    break;
                case ROOM:
                    host.switchedApartType="Room";
                    break;
                case APARTMENT:
                    host.switchedApartType="Apartment";
                    break;
            }*//*
            User client = new User("Bony", "Client1", "gooble@boom");
            //host.registerObserver(client); to change
        } catch (InputMismatchException err) {
            System.out.println("Illegal name / sername / email");
        }*/
        //System.out.println(ApartmentType.PLACE);
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        try {
            factory = Persistence.createEntityManagerFactory("my-persistence-unit");
            manager = factory.createEntityManager();
            manager.getTransaction().begin();
            manager.persist( new User("Blo", "Thisost", "bt@mail", false) );
            //manager.persist( new BlogPost("Just another blog post", "This is second blog post", new Date(), true) );
            manager.getTransaction().commit();

            //TODO: Read all entities from database using EntityManager

        } finally {
            if (manager!=null) manager.close();
            if (factory!=null) factory.close();
        }
    }
}
