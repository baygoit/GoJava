package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "questions")
@NamedQuery(name = "Question.findByProjectId", query = "SELECT q FROM Question q WHERE q.project.id = :projectId")
public class Question implements Serializable{
    private static final long serialVersionUID = -7685128608337454365L;
    @Column
    private String question;
    @Column
    private String answer;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    @Column(insertable = false, updatable = false)
    private int projectId;


    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "projectId")
    private Project project;


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }


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


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(id).
                append(question).
                append(answer).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Question))
            return false;
        if (obj == this)
            return true;

        Question question = (Question) obj;
        return new EqualsBuilder().
                append(question,question.getQuestion()).
                append(answer,question.getQuestion()).
                append(id,question.getId()).
                isEquals();
    }
}