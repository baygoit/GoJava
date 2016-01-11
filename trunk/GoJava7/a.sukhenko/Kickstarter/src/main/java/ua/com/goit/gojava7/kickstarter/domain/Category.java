package ua.com.goit.gojava7.kickstarter.domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category{
	@Column
    private String categoryName;
	@Column
=======
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "categories")
public class Category{
    @Column
    private String categoryName;
    @Id
    @GeneratedValue
    @Column
>>>>>>> b0014930bf8740a544b0060d43ef290b3bc57753
    private int    categoryId;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @Cascade({CascadeType.SAVE_UPDATE})
    private List<Project> projects = new ArrayList<>();
    
    
    public Category() {
    }

    public Category(String categoryName, int categoryId) {
        super();
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category. categoryId: " + categoryId + " categoryName: " + categoryName;
    }
}
