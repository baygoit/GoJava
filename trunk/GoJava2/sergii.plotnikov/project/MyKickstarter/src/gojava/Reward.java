package gojava;

public class Reward {
	
	private int amount;
	private String rewardDescr;
	
	public Reward(int amount, String rewardDescr) {
		this.amount=amount;
		this.rewardDescr=rewardDescr;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public String getRewardDescr(){
		return rewardDescr;
	}
}
