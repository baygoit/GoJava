/**
 * Created by  L Hupalo on 23.09.2015.
 */
public class Client extends User {



    public Client() {
        super();
    }

    public Client(String name, String surname, String email) {
        super(name, surname, email);
    }

    public void update(String message) {
        System.out.println("Hello  " + message);
    }


}