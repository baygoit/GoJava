package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name="Question.getAll", query="select entity from Question as entity"),
	@NamedQuery(name="Question.getByProject", query="select entity from Question as entity where project_id = :project_id"),
	@NamedQuery(name="Question.removeAll", query="delete from Question")
	})
public class Question {
	
	private static final int QUESTION_MIN_SIZE = 10;
	private static final int USERNAME_MIN_SIZE = 3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="project_id", foreignKey=@ForeignKey(name="question_project_id_fkey"))
    private Project project;
	
	@Column(name="username")
	@Size(min=USERNAME_MIN_SIZE, 
			message="User name must have at least  " + USERNAME_MIN_SIZE + " characters length")
    private String user;
	
	@Size(min=QUESTION_MIN_SIZE, 
			message="Question text must have at least " + QUESTION_MIN_SIZE + " characters length")
    private String question;
    private String answer;

    public Question() {
        // default bean constructor
    }

    public Question(Project project, String question, String answer) {
        this.setProject(project);
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

    @Override
	public String toString() {
		return "Question [user=" + user + ", question=" + question + ", answer=" + answer + ", project=" + project + "]";
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
