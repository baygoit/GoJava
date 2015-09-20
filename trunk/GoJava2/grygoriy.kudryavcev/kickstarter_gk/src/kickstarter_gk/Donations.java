package kickstarter_gk;

public class Donations {

	int idDonation;
	Donators donator;
	int CardNumber;
	float donations;
	Project project;
	
	public Donations(int idDonation, Donators donator, int cardNumber,
			float donations, Project project) {
		super();
		this.idDonation = idDonation;
		this.donator = donator;
		CardNumber = cardNumber;
		this.donations = donations;
		this.project = project;
	}
	
}


