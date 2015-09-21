/**
 * Created by root on 19.09.15.
 */
public class User implements Observer {

    private String name;
    private String surname;
    private String email;

    public User() {}    // constructor without parameters for iherited classes: Host and Client
    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(String s) {
        System.out.println("On email " + getEmail() + " " + getName() + " "
                + getSurname() + " get message: The new city was added " + s);
    }
}
