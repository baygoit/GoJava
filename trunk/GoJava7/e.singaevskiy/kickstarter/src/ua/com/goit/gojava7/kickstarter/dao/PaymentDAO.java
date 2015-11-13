package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.User;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class PaymentDAO extends CommonDAO<Payment> {

    public PaymentDAO() {

        dataSource.add(new Payment(new User("John"), 123312L, 200L, Utils.dateFromString("25.04.2015")));
        dataSource.add(new Payment(new User("Adam"), 53245452L, 300L, Utils.dateFromString("25.05.2015")));
        dataSource.add(new Payment(new User("Sue"), 15435356L, 400L, Utils.dateFromString("25.06.2015")));
        dataSource.add(new Payment(new User("Sam"), 830956L, 500L, Utils.dateFromString("21.10.2015")));
        dataSource.add(new Payment(new User("Pam"), 123754L, 250L, Utils.dateFromString("22.09.2015")));
        dataSource.add(new Payment(new User("Gwen"), 2536356L, 340L, Utils.dateFromString("01.05.2015")));
        dataSource.add(new Payment(new User("Rob"), 3679865325L, 230L, Utils.dateFromString("25.03.2015")));
        dataSource.add(new Payment(new User("Bob"), 123435634L, 540L, Utils.dateFromString("25.05.2015")));
        dataSource.add(new Payment(new User("Jake"), 12343645L, 550L, Utils.dateFromString("24.05.2015")));
        dataSource.add(new Payment(new User("Ted"), 4343654L, 330L, Utils.dateFromString("20.05.2015")));
        dataSource.add(new Payment(new User("Ned"), 23456546L, 210L, Utils.dateFromString("25.08.2015")));
        dataSource.add(new Payment(new User("Fred"), 2345647543L, 410L, Utils.dateFromString("11.05.2015")));

    }

    public List<Payment> getByUser(User user) {
        return dataSource.stream().filter(payment -> {
            if (payment.getUser().equals(user)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

}
