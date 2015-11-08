package ua.com.goit.gojava.andriidnikitin.MyShop.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="SHOP_ORDER")
public class CustomerBasket implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(columnDefinition="serial",name="order_id")
	private Integer id;
	
	@Column(name="date_of_order")
	@Type(type="date")
	private Date date;

	/*@SuppressWarnings("unused")
	private CustomerDetails customer;
	*/
	
	@OneToMany(mappedBy="basket", fetch = FetchType.EAGER)
	private Set<GoodRecord> order;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<GoodRecord> getRecords() {
		return order;
	}
	
	public void setRecords(Set<GoodRecord> records) {
		this.order = records;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		CustomerBasket other = (CustomerBasket) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<GoodRecord> getOrder() {
		return order;
	}

	public void setOrder(Set<GoodRecord> order) {
		this.order = order;
	}
	
	
}


