package ua.com.goit.gojava.andriidnikitin.MyShop.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GOOD_TYPE")
public class GoodType implements Serializable {
	
	private static final long serialVersionUID = 5672782960646928322L;
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="TYPE_ID")
	private Integer id;	

	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinTable(name = "TYPE_ID")
	private GoodType parent;
	
	@OneToMany
	@JoinTable(name = "TYPE_ID")
	private Set<GoodType> children;
	
	@OneToMany
	@JoinTable(name = "TYPE_ID")
	private Set<Good> goods;
	
	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
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
	
	public GoodType getParent() {
		return parent;
	}	
	
	public void setParent(GoodType parent) {
		this.parent = parent;
	}
	
	public Set<GoodType> getChildren() {
		return children;
	}

	public void setChildren(Set<GoodType> children) {
		this.children = children;
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
		GoodType other = (GoodType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
