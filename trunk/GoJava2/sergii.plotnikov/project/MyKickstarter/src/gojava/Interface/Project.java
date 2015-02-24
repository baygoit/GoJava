package gojava.Interface;

import gojava.Payment;

public interface Project {

	abstract String getTitle();

	abstract String getShortDescr();

	abstract int getPositionsLength();

	abstract void addQuestion(String q);

	abstract int getRewardsLength();

	abstract int getRewardPrice(int i);
	
	abstract Payments getPayments();

	abstract void makePayment(Payment p, int amount);

	abstract String shortProjectDescr();

	abstract String showProject();

}