package jpa;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iduser")
    private int id;
    @Column
    private String name;
//    @Column
//    private String surname;
//    @Column
//    private String email;
//    @OneToMany(mappedBy = "id")
//    private List<Apartament> apartaments;

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
//    @Override
//    public String toString() {
//        return "User{" +
//
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<Apartament> getApartaments() {
//        return apartaments;
//    }
//
//    public void setApartaments(List<Apartament> apartaments) {
//        this.apartaments = apartaments;
//    }
//public static void main(String[] args) {
//
//    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
//    @PersistenceContext
//    EntityManager em ;
//
//    User user = em.find(User.class, 1);
//
//    List<Apartament> apartaments = user.getApartaments();
//    for (Apartament apartament : apartaments) {
//        System.out.println(apartament);
//    }
//
//   // System.out.println(user);
//    em.close();
//    emf.close();
//}
}
