package ua.com.goit.gojava7.kickstarter.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

@Entity
@NamedQueries({
	@NamedQuery(name="Project.getAll", query="select entity from Project as entity"),
	@NamedQuery(name="Project.getByCategory", query="select entity from Project as entity where category_id = :category_id"),
	@NamedQuery(name="Project.removeAll", query="delete from Project")
	})
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long goalSum;
    @Formula("(select SUM(p.sum) from payment p where p.project_id = id)")
    private Long balanceSum;
    private Date startDate;
    private Date endDate;
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH})
    @JoinColumn(name="category_id", foreignKey=@ForeignKey(name="project_category_id_fkey"))
    private Category category;
    private String description;
    private String videoUrl;
    private String author;
    @OneToMany(mappedBy="project", fetch=FetchType.EAGER)
    private List<Question> questions = new ArrayList<Question>();

    public Project() {
        // default bean constructor
    }

    public Project(String name, String author, Category category) {
        this.name = name;
        this.setCategory(category);
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGoalSum() {
        return goalSum;
    }

    public void setGoalSum(long goalSum) {
        this.goalSum = goalSum;
    }

    public Long getBalanceSum() {
    	if(balanceSum == null) {
    		return 0L;
    	}
        return balanceSum;
    }

    public void setBalanceSum(Long balanceSum) {
   		this.balanceSum = balanceSum;    
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long daysLeft() {
        long ms = 0;
        if (getEndDate() != null) {
            ms = getEndDate().getTime() - System.currentTimeMillis(); 
        }
        if (ms < 0) {
            return 0;
        }
        return ms / (1000L * 60L * 60L * 24L);
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
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "("+id+") Project \"" + name.substring(0, Math.min(15, name.length())) + "..." + "\" by " + author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
