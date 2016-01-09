package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bonuses")
public class Bonus{
    @Id @GeneratedValue
    @Column
    private int id;
    @Column
    private int projectId;
    @Column
    private double amount;
    @Column
    private String bonus;
}
