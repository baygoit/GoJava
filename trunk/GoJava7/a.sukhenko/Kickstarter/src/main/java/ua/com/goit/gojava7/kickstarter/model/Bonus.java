package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "bonuses")
public class Bonus implements Serializable{
    
    private static final long serialVersionUID = -7359359990140227169L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int     id;
    @Column(name = "projectId", insertable = false, updatable = false)
    private int     projectId;
    @Column
    private double  amount;
    @Column
    private String  bonus;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "projectId")
    private Project project;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getBonus() {
        return bonus;
    }
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

}
