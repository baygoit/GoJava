package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;

public class PaymentFileDAO extends FileDAO<Payment> implements PaymentStorage {

    public PaymentFileDAO() {
        super(Payment.class);
    }

    public PaymentFileDAO(String pathToFile) {
        super(Payment.class, pathToFile);
    }

}
