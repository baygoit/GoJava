package ua.com.goit.gojava.andriidnikitin.MyShop.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GOOD")
public class Good {
	
	@Id
    @GeneratedValue
    @Column(columnDefinition="serial",name="good_id")
	private Integer id;
	
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private GoodType type;
	
	@OneToMany(mappedBy="good")
	private Set<GoodRecord> records;

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public Set<GoodRecord> getRecords() {
		return records;
	}

	public void setRecords(Set<GoodRecord> records) {
		this.records = records;
	}
			
}

