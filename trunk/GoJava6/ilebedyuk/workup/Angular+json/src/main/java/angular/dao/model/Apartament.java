package angular.dao.model;

import javax.persistence.*;

/**
 * Created by Игорь on 16.12.2015.
 */
@Entity
@Table(name="apartament")
public class Apartament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idaparnaments")
    private int idAparnament;

    @Column(name = "type")
    private String apartmentType;

    @Column
    private String city;

    @Column(name = "iduser")
    private int ownerId;

    @Column(name="Cost")
    private int cost;

    @Column(name="Description")
    private String description;

    @Column(name="idphoto")
    private String idphoto;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdphoto(String idphoto) {
        this.idphoto = idphoto;
    }

    @Column
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public String getIdphoto() {
        return idphoto;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "idAparnament=" + idAparnament +
                ", apartmentType='" + apartmentType + '\'' +
                ", city='" + city + '\'' +
                ", ownerId=" + ownerId +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", idphoto='" + idphoto + '\'' +

                ", capacity=" + capacity +
                '}';
    }

    public Apartament(){}

    public Apartament(String apartmentType, String city, int cost, String description, String idphoto) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.cost = cost;
        this.description = description;
        this.idphoto = idphoto;
    }

    public Apartament(String apartmentType, String city, int ownerId, int cost, String description, String idphoto, int capacity) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerId = ownerId;
        this.cost = cost;
        this.description = description;
        this.idphoto = idphoto;
        this.capacity = capacity;
    }

    public Apartament(String apartmentType, String city, int ownerId) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerId = ownerId;

    }

    public String getApartmentType() {
        return apartmentType;
    }

    public String getCity() {
        return city;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public int getIdAparnament() {
        return idAparnament;
    }

    public void setIdAparnament(int idAparnament) {
        this.idAparnament = idAparnament;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOwnerId() {
        return ownerId;
    }

}
