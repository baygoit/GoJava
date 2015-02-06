package gojava;

import java.util.LinkedList;
import java.util.List;

public class Payments {

	private List <Payment> payments;
	private List <Reward> rewards;
	
	public Payments(){
		payments = new LinkedList<Payment>();
		rewards = new LinkedList <Reward>();
		fillRewards();
	}
	
	public void makePayment(Payment p) { payments.add(p);}
	
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
	
	public int getRewardsLength() {	return rewards.size();}
}
