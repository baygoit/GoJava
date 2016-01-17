package ua.com.goit.gojava7.kickstarter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "question")
	private String question;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Faq : [qustion=" + question + "]";
	}

	@Override
	public boolean equals(Object that) {
		if (that == null) {
			return false;
		}
		if (!this.getClass().equals(that.getClass())) {
			return false;
		}

		Faq faq = (Faq) that;
		if (this.id == faq.getId() && this.question.equals(faq.getQuestion())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int faqHashCode = 0;
		faqHashCode = (id + question).hashCode();
		return faqHashCode;
	}
}
