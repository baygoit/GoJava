package airbnb.model;

import airbnb.common.Observer;

/**
 * Created by slavik on 21.09.2015.
 */
public class User implements Observer {
    private String name, surname, email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void update(String message) {
        System.out.println("send message: " + message + " to " + email);
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String input) { name = input; }
    public void setSurname(String input) { surname = input; }
    public void setEmail(String input) { email = input; }
    @Override
    public String toString() {
        return "Name " + name + " Surname " + surname + " email";
    }
    public boolean validate() {
        return Validation.validateName(name) &&
                Validation.validateSurname(surname) &&
                Validation.validateEmail(email);
    }

}
