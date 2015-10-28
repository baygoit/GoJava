package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.persistence.GenerationType;

@Entity
@Table(name="CATEGORIES", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Category {

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private List<Project> projects;
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;
	
	public List<Project> getProjects() {
		return this.projects;
	}
 
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
