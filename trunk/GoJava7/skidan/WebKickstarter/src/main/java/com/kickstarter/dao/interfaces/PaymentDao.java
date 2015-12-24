package com.kickstarter.dao.interfaces;



public interface PaymentDao {

	public Integer getAll(int projectId);

	public void addPayment(int projectId, int amount);
}