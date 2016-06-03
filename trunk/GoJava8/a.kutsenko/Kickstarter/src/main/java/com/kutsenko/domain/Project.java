package com.kutsenko.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table(name = "project")
@NamedEntityGraphs({
    @NamedEntityGraph(name = "graph.Project.questions", attributeNodes = @NamedAttributeNode("questions")),
    @NamedEntityGraph(name = "graph.Project.rewards", attributeNodes = @NamedAttributeNode("rewards")) })
public class Project {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "required_budget")
    private int requiredSum;
    @Column(name = "gathered_budget")
    private int gatheredBudget;
    @Column(name = "days_to_go")
    private int remainingDays;
    @Column
    private String history;
    @Column(name = "url_video")
    private String videoUrl;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Investment> investments;
    @OneToMany(mappedBy = "project")
    @SortNatural
    private List<Question> questions;
    @OneToMany(mappedBy = "project")
    @SortNatural
    private List<Reward> rewards;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setRequiredSum(int requiredSum) {
        this.requiredSum = requiredSum;
    }

    public int getRequiredSum() {
        return requiredSum;
    }

    public int getCollectedSum() {
        int collectedSum = 0;
        for (Investment investment : investments) {
            collectedSum += investment.getAmount();
        }
        return collectedSum;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setVideoUrl(String videoURL) {
        this.videoUrl = videoURL;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    

    public Set<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

   

    public int getGatheredBudget() {
    	return gatheredBudget;
    }
    
    public void setGatheredBudget(int gatheredBudget) {
    	this.gatheredBudget = gatheredBudget;
    }
    
    public List<Question> getQuestions() {
    	return questions;
    }
    
    public void setQuestions(List<Question> questions) {
    	this.questions = questions;
    }
    
    public List<Reward> getRewards() {
    	return rewards;
    }
    
    public void setRewards(List<Reward> rewards) {
    	this.rewards = rewards;
    }
}