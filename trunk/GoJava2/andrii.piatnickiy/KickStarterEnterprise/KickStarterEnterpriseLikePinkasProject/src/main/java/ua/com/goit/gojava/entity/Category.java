package ua.com.goit.gojava.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;

}
