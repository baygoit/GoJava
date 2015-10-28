package KickStarter.model;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:42
 * @version: 1.0
 */

//@XmlType(propOrder={"id", "name"})
@XmlRootElement(name = "Category")
@XmlAccessorType (XmlAccessType.FIELD)
public class Category {
    @XmlAttribute
    public String name;

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

    @XmlAttribute
    private int Id;

    public Category(int pId, String pName) {
        name = pName;
        Id = pId;
    }

    public int getId() {
        return Id;
    }

    public Category() {
    }
}
