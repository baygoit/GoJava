package ua.com.goit.gojava.andriidnikitin.model;

import java.util.List;

public class Basket {
	
	private Integer id;
	
	private List<BasketGood> goods;
	
	private Client client;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<BasketGood> getGoods() {
		return goods;
	}

	public void setGoods(List<BasketGood> goods) {
		this.goods = goods;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

}
