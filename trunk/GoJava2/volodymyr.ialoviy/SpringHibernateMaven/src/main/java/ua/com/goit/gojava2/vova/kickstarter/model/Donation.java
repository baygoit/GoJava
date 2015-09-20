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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DONATION")
public class Donation{
	
	public Donation(){
		
	}
	
	public Donation(int idDonator, int idProject, int amount){
		this.idDonator = idDonator;
		this.idProject = idProject;
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "ID_DONATOR", nullable = false, insertable = false, updatable = false)
	private Donator donator;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotNull
    @Column(name = "ID_DONATOR")
    private int idDonator;

	@NotNull
    @Column(name = "ID_PROJECT")
    private int idProject;
	
	@NotNull
	@Column(name = "AMOUNT")
	private int amount;

	public Donator getDonator() {
		return donator;
	}

	public void setDonator(Donator donator) {
		this.donator = donator;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDonator() {
		return idDonator;
	}

	public void setIdDonator(int idDonator) {
		this.idDonator = idDonator;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}