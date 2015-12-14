package entity._old;

import entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities", catalog = "entity")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String code;
    private String name;
    private Country country;
    private List<User> users = new ArrayList<>(0);

    public City() {
    }

    public City(String code, String name, Country country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    //==============getters==============

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "code", unique = true, nullable = false)
    public String getCode() {
        return code;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName="id")
    public Country getCountry() {
        return country;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public List<User> getUsers() {
        return users;
    }



    //==============setters==============

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
