package ua.com.goit.gojava7.kickstarter.domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
=======
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
>>>>>>> b0014930bf8740a544b0060d43ef290b3bc57753
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question{
<<<<<<< HEAD
	@Column
    private String time;
	@Column
    private String question;
	@Column
    private String answer;
	@Column
    private String projectName;
=======
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private int     id;

    @Column
    private String  question;
    @Column
    private String  answer;
    
    @Column
    private int projectId;
    
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project = new Project();
>>>>>>> b0014930bf8740a544b0060d43ef290b3bc57753

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
