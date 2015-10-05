package airbnb.model;

public class User {
    private static int nextUserID = 0;
    private int userID;
    private String name, surname, email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        userID = nextUserID++;
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
    public int getUserID() { return userID; }
    public int getTotalUserID() { return nextUserID; }
    @Override
    public String toString() {
        return "ID " + userID + " Name " + name + " Surname " + surname + " email " + email;
    }
    public boolean validate() {
        return Validation.validateName(name) &&
                Validation.validateName(surname) &&
                Validation.validateEmail(email);
    }

}
