package obcerver;

/**
 * Created by macmini on 20.09.15.
 */
public class User implements Observer{

    public String name;
    public String surname;
    public final String mail ;


    public User(String name, String surname, String mail) {

        this.mail = mail;
    }


    public String getName (){

        return name;
        }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname (){

        return surname;
    }

    public void setSurname (String surname) {

        this.surname = surname;
    }

    public String getMail(){

        return mail;
    }

    @Override
    public void update(String message) {
        System.out.println("Hello!" + getName());

    }
}

