package gojava.DAO;

import gojava.Payment;
import gojava.Interface.Payments;

public class DAOPayments implements Payments{
	private int index;
	
	public DAOPayments(int i){
		index=i;
	}

	@Override
	public void makePayment(Payment p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String showRewards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRewardsLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getReward(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
