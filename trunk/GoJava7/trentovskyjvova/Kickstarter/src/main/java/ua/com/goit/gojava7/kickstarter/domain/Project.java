package ua.com.goit.gojava7.kickstarter.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "project")
public class Project {
	@Column
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	@Column
	private Long daysToGo;
	@Column
	private String description;
	@Column
	private String owner;
	@Column
	private Long goal;
	@Column
	private String videoUrl;
	
	//@Transient
	@Formula("(select coalesce(sum(p.pledge), 0) from payment p where p.projectid = id)")
	private Long amountPledge;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
	private Set<Payment> payments = new HashSet<Payment>();
	
	public Project() {
		
	}
	
	public Project(String name, Long id) {
		this.name = name;
		this.id = id;

		this.daysToGo = 40L;
		this.description = "";
		this.owner = "";
		this.goal = 0L;
		this.videoUrl = "";
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(Long daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getGoal() {
		return goal;
	}

	public void setGoal(Long goal) {
		this.goal = goal;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getFunded() {
		return goal == 0 ? 0 : getAmountPledge() * 100 / goal;
	}

	public Long getAmountPledge() {
		return amountPledge;
	}

	public void setAmountPledge(Long amountPledge) {
		this.amountPledge = amountPledge;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("description", description)
				.append("daysToGo", daysToGo).append("goal", goal).append("amountPledge", amountPledge)
				.toString();
	}
	
}
