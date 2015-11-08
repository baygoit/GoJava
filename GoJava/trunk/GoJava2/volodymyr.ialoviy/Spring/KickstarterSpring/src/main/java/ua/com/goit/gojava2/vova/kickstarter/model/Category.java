package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category{
	
	@Id
    @Column(name= "id_category")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCategory;
	
	@Column(name= "name_category")
	private String nameCategory;
	
	@OneToMany
	private List<Project> projects;
	
	public Category(int IdCategory, String nameCategory) {
		this.idCategory = IdCategory;
		this.nameCategory = nameCategory;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", idCategory, nameCategory);
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int IdCategory) {
		this.idCategory = IdCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}
