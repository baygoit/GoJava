package goit.nz.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FAQS")
public class FAQ {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAQ_SEQ")
	@SequenceGenerator(name = "FAQ_SEQ", sequenceName = "APP.FAQS_ID_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private long id;
	@Column
	private String question;
	@Column
	private String answer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	public FAQ() {
	};

	public FAQ(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

}
