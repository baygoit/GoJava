package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 21.11.2015.
 */
@Entity
@Table (name = "Cities")
public class City {
    @Id
    @Column (name =  "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name")
    private String name;
    @OneToMany(mappedBy = "city_id")
    private ArrayList<Apartment> apartmentList;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addApartment(Apartment apartment) {
        this.apartmentList.add(apartment);
    }

    public List<Apartment> getApartments() {
        return this.apartmentList;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
