package ua.com.goit.gojava.andriidnikitin.MyShop.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails implements Serializable, Cloneable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@Id
    @GeneratedValue
    @Column(columnDefinition="serial",name="basket_id")
	private Integer id;

	@Column(name="name")
	private String name;	
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;		

}
