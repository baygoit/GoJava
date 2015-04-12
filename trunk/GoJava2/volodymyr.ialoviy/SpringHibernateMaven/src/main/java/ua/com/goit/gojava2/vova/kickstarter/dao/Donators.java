package ua.com.goit.gojava2.vova.kickstarter.dao;

import org.springframework.stereotype.Repository;
import ua.com.goit.gojava2.vova.kickstarter.model.Donator;

@Repository("donatorDao")
public class Donators extends AbstractDao implements DonatorDao {

	@Override
	public void saveDonator(Donator donator) {
		getSession().save(donator);
	}
}
