package airbnb;

import java.util.Scanner;

/**
 * Created by mazha on 9/29/2015.
 */
abstract public class User {

    private String name;
    private String surname;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) throws MyException {
        if(name != null && !name.isEmpty() && !name.matches(".*\\d.*")) {
            this.name = name;
        }else throw new MyException();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws MyException{
        if(surname != null && !surname.isEmpty() && !surname.matches(".*\\d.*")) {
            this.surname = surname;
        }else throw new MyException();
    }

    public String getEmail() {
        return email;
    }

    // honestly stolen regex for validation, but that's all that copy and paste yet;
    public void setEmail(String email) throws MyException {

        if(email != null && !email.isEmpty() && email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){
            this.email = email;
        }else throw new MyException();
    }


    abstract void registerNew(Scanner scanner) throws MyException;
}
