package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;

public class PaymentMemoryDAO extends MemoryDAO<Payment> implements PaymentStorage{

    public PaymentMemoryDAO(List<Payment> dataSource) {
        super(dataSource);
    }

}
