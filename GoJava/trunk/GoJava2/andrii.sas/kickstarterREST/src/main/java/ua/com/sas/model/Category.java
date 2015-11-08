package ua.com.sas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="categories")
public class Category {
	
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private List<Project> projects;
    
    public List<Project> getProjects() {
    	return projects;
    }

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
