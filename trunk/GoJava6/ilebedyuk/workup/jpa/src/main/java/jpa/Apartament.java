package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
@Entity
@Table(name="apartament")
public class Apartament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idapart")
    private int id;
    @Column
    private String city;
    @ManyToOne
    @JoinColumn(name = "ownerid")
    private User user;
    @Column
    private String room;

    @Override
    public String toString() {
        return "Apartament{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", user=" + user +
                ", room='" + room + '\'' +
                '}';
    }

    public Apartament(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        List<Apartament> apartaments = em.createQuery("select a from Apartament a", Apartament.class).getResultList();
        for (Apartament apartament : apartaments) {
            System.out.println(apartament);

        }

        em.close();
        emf.close();
    }
}
