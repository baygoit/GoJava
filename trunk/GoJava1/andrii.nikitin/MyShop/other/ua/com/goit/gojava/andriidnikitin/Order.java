package ua.com.goit.gojava.andriidnikitin;

import java.util.Date;

import ua.com.goit.gojava.andriidnikitin.model.Address;
import ua.com.goit.gojava.andriidnikitin.model.Client;
import ua.com.goit.gojava.andriidnikitin.model.DeliveryType;
import ua.com.goit.gojava.andriidnikitin.model.OrderStatus;

public class Order {
	
	Integer id;
	
	Basket basket;
	
	Address deliveryAddress;
	
	Date deliveryDate;
	
	DeliveryType deliveryType;
	
	Client client;
	
	OrderStatus status;
	
	String details;
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setStatus(OrderStatus status) {
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
		return deliveryAddress;
	}
	public void setAddressOfDelivery(Address addressOfDelivery) {
		this.deliveryAddress = addressOfDelivery;
	}
	public Date getDateOfDelivery() {
		return deliveryDate;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.deliveryDate = dateOfDelivery;
	}
	public DeliveryType getTypeOfDelivery() {
		return deliveryType;
	}
	public void setTypeOfDelivery(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
