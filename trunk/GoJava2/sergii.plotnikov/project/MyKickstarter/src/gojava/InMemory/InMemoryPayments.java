package gojava.InMemory;

import gojava.Payment;
import gojava.Reward;
import gojava.Interface.Payments;

import java.util.LinkedList;
import java.util.List;

public class InMemoryPayments implements Payments {

	private List <Payment> payments;
	private List <Reward> rewards;
	
	public InMemoryPayments(){
		payments = new LinkedList<Payment>();
		rewards = new LinkedList <Reward>();
		fillRewards();
	}
	
	@Override
	public void makePayment(Payment p) { payments.add(p);}
	
	@Override
	public String showRewards(){
		String result="";
		int num = 1;
		for(int i = 0; i < rewards.size(); i++){
			result+=num + " - " + getReward(i).getAmount() + "$, " + 
					getReward(i).getRewardDescr() + "\n";
			num++;
		}
		result+=num + " - Another amount\n0 - Go back\n";
		
		return result;
	}
	
	public void fillRewards(){
		rewards.add(new Reward(1, "thanks!"));
		rewards.add(new Reward(5, "thank you!"));
		rewards.add(new Reward(10, "THANK YOU!"));
	}

	public Reward getReward(int i){	return rewards.get(i);}
	
	@Override
	public int getRewardsLength() {	return rewards.size();}
}
