package ua.com.goit.gojava.andriidnikitin.MyShop.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GOOD_RECORD")
public class GoodRecord {
	
	@Id
    @GeneratedValue
    @Column(columnDefinition="serial",name="record_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "good_id")
	private Good good;	
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="price")
	private Integer price;
	
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
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
	
	

}
