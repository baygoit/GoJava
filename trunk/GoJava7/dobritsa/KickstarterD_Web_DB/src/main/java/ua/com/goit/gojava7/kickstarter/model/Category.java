package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "category")
@NamedQueries({ @NamedQuery(name = "Category.getAll", query = "select c from Category c") })
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long categoryId;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Project> projects = new ArrayList<>();
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}		
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;

		if (this.categoryId != null & other.categoryId != null) {
			if (this.categoryId != other.categoryId) {
				return false;
			}
		}

		if (this.name != null & other.name != null) {
			if (this.name != other.name) {
				return false;
			}
		}

		return true;
	}
}