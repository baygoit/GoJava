package ua.com.goit.gojava2.vova.kickstarter.dao;

import org.springframework.stereotype.Repository;
import ua.com.goit.gojava2.vova.kickstarter.model.Donation;


@Repository("donationDao")
public class Donations extends AbstractDao implements DonationDao {

	@Override
	public void saveDonation(Donation donation) {
		getSession().save(donation);		
	}
}
