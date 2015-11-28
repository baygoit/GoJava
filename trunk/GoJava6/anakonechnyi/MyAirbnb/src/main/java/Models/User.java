package models;



import observerFr.Observer;
import observerFr.Subject;

import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 19.09.2015.
 */

@Entity
@Table (name = "users")
public class User implements Observer {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;
    @Column (name = "name")
    private String name;
    @Column (name = "sur_name")
    private String surname;
    @Column (name = "email")
    private String email;
    @Column (name = "is_host")
    private Boolean isHost;
    @OneToMany (mappedBy = "host_id")
    public List<Apartment> apartments;
    //private String city;



    public User (/*int clientId,*/ String name, String surname, String email , boolean isHost){
        if (this.setName(name)&&this.setSurname(surname)&&this.setEmail(email)) {
            this.isHost=isHost;
            /*this.clientId= clientId;*/
            System.out.println("Successful Host registration");
            //Searches.hostList.add(this);
            //TODO addToDB method
        } else {
            throw new InputMismatchException();
        }
    }
    /*public User (String name, String surname, String email){
        if (this.setName(name)&&this.setSurname(surname)&&this.setEmail(email)) {
            this.isHost=false;
            clientId= (int) Math.random();
            System.out.println("Successful Host registration");
            Searches.hostList.add(this);
        } else {
            throw new InputMismatchException();
        }
    }
*/
    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        //to test
        if (name.isEmpty()||name.equals("Null")||name.matches(".*\\d+.*")) {return false;}
        this.name = name;
        return true;
    }

    public String getSurname() {
        return surname;
    }

    public boolean setSurname(String surname) {
        if (surname.isEmpty()||surname.equals("Null")||surname.matches(".*\\d+.*")) {return false;}
        this.surname = surname;
        return true;

    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email.isEmpty()||email.equals("Null")||!(email.contains("@"))) {return false;}
        this.email = email;
        return true;
    }

    public void setNewApartments (String next) {
        ApartmentType type = ApartmentType.valueOf(next);
        // TODO apartments.add(new Apartment(??? id ???,  type, this, "Kyiv"));
    }

    public String toString(){
        return this.getName()/*+" in "+this.getCity()*/;
    }
/*

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
*/
    public Boolean getIsHost() { return isHost;}

    public void setLikeHost() { this.isHost=true;}

 //   public int getClientId() {return clientId;}
//?????    @Override
    public void update(Object obj) {

    }

    @Override
    public void loyalty(int discountPercent, Subject s) {

        System.out.println("Hello, "+getName()+". You have "+discountPercent+"% discount  from "+s.toString());
    }

    public int getClientId() {
        return clientId;
    }
}
