package gojava.Interface;

import gojava.Payment;

public interface Payments {

	abstract void makePayment(Payment p);

	abstract String showRewards();

	abstract int getRewardsLength();

	abstract Object getReward(int i);

}