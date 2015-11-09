package com.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.kickstarter.beans.Payment;
import com.kickstarter.beans.User;
import com.kickstarter.util.Utils;

public class PaymentDAO extends CommonDAO<Payment> {

	public PaymentDAO() {

		dataSource.add(new Payment(new User("John"), 123312L, 200L, Utils.dateFromString("25.04.2015")));
		dataSource.add(new Payment(new User("Adam"), 53245452L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Sue"), 15435356L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Sam"), 830956L, 200L, Utils.dateFromString("21.10.2015")));
		dataSource.add(new Payment(new User("Pam"), 123754L, 200L, Utils.dateFromString("22.09.2015")));
		dataSource.add(new Payment(new User("Gwen"), 2536356L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Rob"), 3679865325L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Bob"), 123435634L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Jake"), 12343645L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Ted"), 4343654L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Ned"), 23456546L, 200L, Utils.dateFromString("25.05.2015")));
		dataSource.add(new Payment(new User("Fred"), 2345647543L, 200L, Utils.dateFromString("25.05.2015")));

	}

	public List<Payment> getByUser(User user) {
		List<Payment> filtered = dataSource.stream().filter(payment -> {
			if (payment.getUser().equals(user)) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		return filtered;
	}

}
