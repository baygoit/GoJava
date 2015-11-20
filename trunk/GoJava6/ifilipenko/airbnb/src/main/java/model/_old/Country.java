package model._old;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "countries", catalog = "model")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String code;
    private String name;
    private List<City> city;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
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

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    public List<City> getCity() {
        return city;
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

    public void setCity(List<City> city) {
        this.city = city;
    }
}
