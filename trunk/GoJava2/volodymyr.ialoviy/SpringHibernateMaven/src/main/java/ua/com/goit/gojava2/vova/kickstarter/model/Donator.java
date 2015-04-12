package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DONATOR")
public class Donator{

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "donator")
	private List<Donation> donations;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "MAIL")
	private String mail;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Column(name = "CARD")
	private long card;
	
	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCard() {
		return card;
	}

	public void setCard(long card) {
		this.card = card;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Donator other = (Donator) obj;
		if (mail != other.mail)
			return false;
		return true;
	}
}