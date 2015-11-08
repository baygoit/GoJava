package ua.com.goit.gojava2.vova.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava2.vova.kickstarter.dao.DonatorDao;
import ua.com.goit.gojava2.vova.kickstarter.model.Donator;

@Service("donatorService")
@Transactional
public class DonatorServiceImpl implements DonatorService{

	@Autowired
	private DonatorDao dao;
	
	@Override
	public void saveDonator(Donator donator) {
		dao.saveDonator(donator);
	}

}
