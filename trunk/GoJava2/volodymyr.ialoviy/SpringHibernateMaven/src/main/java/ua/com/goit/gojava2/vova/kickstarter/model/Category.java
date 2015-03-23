package ua.com.goit.gojava2.vova.kickstarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="CATEGORIES")
public class Category {

	@Id
	@Column(name = "ID_CATEGORY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;

	@Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;
	
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		if (idCategory != other.idCategory)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + idCategory + ", name=" + name + "]";
	}
}
