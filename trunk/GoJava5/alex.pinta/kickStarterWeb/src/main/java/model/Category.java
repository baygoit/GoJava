package model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:42
 * @version: 1.0
 */

@Entity
@Table(name = "category")
public class Category {

    @Column(length = 500)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (Id != category.Id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Id;
    }


    public Category(int pId, String pName) {
        name = pName;
        Id = pId;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int pId) {
        Id = pId;
    }
}
