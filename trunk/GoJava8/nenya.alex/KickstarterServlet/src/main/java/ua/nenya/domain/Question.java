package ua.nenya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "QUESTION")
public class Question{
	@Id
	@GenericGenerator(name = "question_id", strategy = "increment")
	@GeneratedValue(generator = "question_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setId(int id) {
		this.id = id;
	}

}
