package ua.com.goit.gojava.kickstarter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="projects_id_seq")
	@SequenceGenerator(name="projects_id_seq", sequenceName="projects_id_seq", allocationSize=1)
	private int id;

	private String description;
	
	@Column(name = "need_money")
	private int needMoney;
	
	@Column(name = "have_money")
	private int haveMoney;
	
	@Column(name = "end_project")
	private int daysBeforeEnd;
	
	@Column(name = "project_history")
	private String projectHistory;
	
	@Column(name = "demo_link")
	private String linkToDemoVideo;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", nullable = false, insertable = true, updatable = false)*/
	
	@Column(name = "id_category")
	private int category_id;
	
	
	//private ArrayList<FAQ> faq = new ArrayList<FAQ>(); //TODO реализовать вопросы ответы

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getNeedMoney() {
		return needMoney;
	}

	public int getHaveMoney() {
		return haveMoney;
	}

	public int getDaysBeforeEnd() {
		return daysBeforeEnd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNeedMoney(int needMoney) {
		this.needMoney = needMoney;
	}

	public void setHaveMoney(int haveMoney) {
		this.haveMoney = haveMoney;
	}

	public void setDaysBeforeEnd(int daysBeforeEnd) {
		this.daysBeforeEnd = daysBeforeEnd;
	}

	public void setProjectHistory(String projectHistory) {
		this.projectHistory = projectHistory;
	}

	public void setLinkToDemoVideo(String linkToDemoVideo) {
		this.linkToDemoVideo = linkToDemoVideo;
	}

	/*public void setFaq(ArrayList<FAQ> faq) {
		this.faq = faq;
	}*/

	public String getProjectHistory() {
		return projectHistory;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getLinkToDemoVideo() {
		return linkToDemoVideo;
	}

	public String toString() {
		return name;
	}

	public String smallProject() {
		String smallProject = name + description + needMoney + haveMoney
				+ daysBeforeEnd;
		return smallProject;
	}

	public void addMoney(int addMoney) {
		this.haveMoney += addMoney;
	}

	/*public ArrayList<FAQ> getFaq() {
		return faq;
	}*/

	/*public void addFAQ(FAQ faq) {
		this.faq.add(faq);
	}*/

}