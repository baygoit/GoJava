package kickstarter_gk;

public class Donators {
	
	String name;
	int CardNumber;
	float totalDonations;
	
	
	public Donators(String name, int cardNumber, float totalDonations) {
		super();
		this.name = name;
		CardNumber = cardNumber;
		this.totalDonations = totalDonations;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
	public float getTotalDonations() {
		return totalDonations;
	}
	public void setTotalDonations(float totalDonations) {
		this.totalDonations = totalDonations;
	}
	
	public void addDonation (float donations){
		totalDonations = totalDonations + donations;
	}
	
}
