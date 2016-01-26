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
    @CollectionTable(name = "question", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "question")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getMoneyNeeded() {
        return moneyNeeded;
    }

    public void setMoneyNeeded(int moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }

    public int getMoneyDonated() {
        return moneyDonated;
    }

    public void setMoneyDonated(int moneyDonated) {
        this.moneyDonated = moneyDonated;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public List<Integer> getSumForBenefit() {
        return sumForBenefit;
    }

    public void setSumForBenefit(List<Integer> sumForBenefit) {
        this.sumForBenefit = sumForBenefit;
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
