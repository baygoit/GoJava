/**
 * Created by L Hupalo on 23.09.2015.
 */
public class User implements Observer {
    private String name;
    private String surname;
    private String email;
    //ValidatorData validatorData = new ValidatorData();

    public User() {

    }

    public User(String name, String surname, String email) {

        if (ValidatorData.validateWords(name) == true && ValidatorData.validateWords(surname) == true && ValidatorData.validateEmail(email) == true) {
            this.name = name;
            this.surname = surname;
            this.email = email;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (ValidatorData.validateWords(name) == true) {
            this.name = name;
        }
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {
        if (ValidatorData.validateWords(surname) == true) {
            this.surname = surname;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (ValidatorData.validateEmail(email) == true) {
            this.email = email;
        }
    }
    public void update(String message) {
        System.out.println( "Hello  " + message);
    }
}