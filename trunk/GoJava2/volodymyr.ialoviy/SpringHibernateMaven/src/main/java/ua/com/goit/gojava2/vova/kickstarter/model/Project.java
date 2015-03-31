package ua.com.goit.gojava2.vova.kickstarter.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Table(name = "PROJECTS")
public class Project{

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "ID_CATEGORY", nullable = false, insertable = false, updatable = false)
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotNull
    @Column(name = "ID_CATEGORY")
    private int idCategory;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Size(min = 15, max = 250)
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	
	@Size(min = 30, max = 500)
	@Column(name = "FULL_DESCRIPTION")
	private String fullDescription;
	
	@Column(name = "FOTO")
	private String foto;
	
	@Column(name = "LINK")
	private String link;
	
	@NotNull
	@Column(name = "HOW_MUCH_NEEDED")
	private int howMuchNeeded;
	
	@NotNull
	@Column(name = "HOW_MUCH_COLLECTED")
	private int howMuchCollected;
	
	@NotNull
	@Column(name = "HOW_MUCH_REMAINING")
	private int howMuchRemaining;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "DATE_CLOSE")
	private LocalDate dateClose;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getHowMuchNeeded() {
		return howMuchNeeded;
	}

	public void setHowMuchNeeded(int howMuchNeeded) {
		this.howMuchNeeded = howMuchNeeded;
	}

	public int getHowMuchCollected() {
		return howMuchCollected;
	}

	public void setHowMuchCollected(int howMuchCollected) {
		this.howMuchCollected = howMuchCollected;
	}

	public int getHowMuchRemaining() {
		return howMuchRemaining;
	}

	public void setHowMuchRemaining(int howMuchRemaining) {
		this.howMuchRemaining = howMuchRemaining;
	}

	public LocalDate getDateClose() {
		return dateClose;
	}

	public void setDateClose(LocalDate dateClose) {
		this.dateClose = dateClose;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Project))
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + "name=" + name + ", dateClose=" + dateClose + "]";
	}

}