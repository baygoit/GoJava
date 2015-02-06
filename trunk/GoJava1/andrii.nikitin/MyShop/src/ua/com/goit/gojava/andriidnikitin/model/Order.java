package ua.com.goit.gojava.andriidnikitin.model;

import java.util.Date;

public class Order {
	
	Integer id;
	
	Basket basket;
	
	Address addressOfDelivery;
	
	Date dateOfDelivery;
	
	TypeOfDelivery typeOfDelivery;
	
	Client client;
	
	StatusOfOrder status;
	
	String details;
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setStatus(StatusOfOrder status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	public Address getAddressOfDelivery() {
		return addressOfDelivery;
	}
	public void setAddressOfDelivery(Address addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public TypeOfDelivery getTypeOfDelivery() {
		return typeOfDelivery;
	}
	public void setTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
		this.typeOfDelivery = typeOfDelivery;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
