package ua.com.goit.gojava.andriidnikitin.MyShop.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GOOD_RECORD")
public class GoodRecord {
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="RECORD_ID")
	private Integer id;
	
	@ManyToOne
	@JoinTable(name = "GOOD_ID")
	private Good good;	
	
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}

	private Integer amount;
	
	private BigDecimal price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}	

}
