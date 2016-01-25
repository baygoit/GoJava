package ua.com.goit.gojava7.kickstarter.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @Column(name = "history")
    private String history;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "money_needed")
    private int moneyNeeded;

    @Column(name = "money_donated")
    private int moneyDonated;

    @Column(name = "days_left")
    private int daysLeft;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> questions = new ArrayList<>();

    @Transient
    private List<String> benefits;

    @Transient
    private List<Integer> sumForBenefit;

    public Project() {
        this.benefits = new ArrayList<>();
        this.sumForBenefit = Arrays.asList(1, 10, 40); // currently hardcoded
    }

    public Project(String name, Category category, String shortDescription, String description, String history,
                   String videoUrl, int moneyNeeded, int daysLeft)
    {
        this();
        this.name = name;
        this.category = category;
        category.add(this);
        this.shortDescription = shortDescription;
        this.description = description;
        this.history = history;
        this.videoUrl = videoUrl;
        this.moneyNeeded = moneyNeeded;
        this.moneyDonated = 0;
        this.daysLeft = daysLeft;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getHistory() {
        return history;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getMoneyNeeded() {
        return moneyNeeded;
    }

    public int getMoneyDonated() {
        return moneyDonated;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public List<Integer> getSumForBenefit() {
        return sumForBenefit;
    }

    public void addMoneyDonated(int money) {
        moneyDonated += money;

        if (money < moneyNeeded) {
            moneyNeeded -= money;
        } else {
            moneyNeeded = 0;
        }
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public void addBenefitItem(String benefit) {
        benefits.add(benefit);
    }

}
