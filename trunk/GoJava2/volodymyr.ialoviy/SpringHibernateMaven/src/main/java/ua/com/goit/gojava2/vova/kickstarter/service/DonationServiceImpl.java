package ua.com.goit.gojava2.vova.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava2.vova.kickstarter.dao.DonationDao;
import ua.com.goit.gojava2.vova.kickstarter.model.Donation;

@Service("donationService")
@Transactional
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationDao dao;
	
	@Override
	public void saveDonation(Donation donation) {
		dao.saveDonation(donation);
	}

}
