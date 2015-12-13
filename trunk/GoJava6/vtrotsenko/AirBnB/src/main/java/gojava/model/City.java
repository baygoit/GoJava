package gojava.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by root on 17.11.15.
 */
@Entity
@Table(name = "City")
public class City extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name = "cityName")
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {}

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return ("City[ Id: " + this.getId() + ", CityName: " +this.getCityName() + "]");
    }
}
