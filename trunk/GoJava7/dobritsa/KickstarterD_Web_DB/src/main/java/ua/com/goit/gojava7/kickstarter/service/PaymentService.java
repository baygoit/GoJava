package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;

@Repository
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private MyValidator myValidator;

    public boolean createPayment(String name, String card, Long amount, Long projectId) {
        log.info("<boolean> createPayment(name = {}, card = {}, amount = {}, projectId = {})...", name, card, amount, projectId);

        if (myValidator.validatePayer(name, card)) {
            Payment payment = new Payment(name, card, amount,  projectDao.get(projectId));
            log.info("<boolean> createPayment(name = {}, card = {}, amount = {}, projectId = {}) created payment {}", name, card, amount, projectId, payment);

            paymentDao.add(payment);
            log.info("<boolean> createPayment(name = {}, card = {}, amount = {}, projectId = {}) added payment to DB", name, card, amount, projectId, payment);
            return true;
        }
        log.error("<boolean> createPayment(name = {}, card = {}, amount = {}, projectId = {}) could not create payment", name, card, amount, projectId);
        return false;
    }
}
