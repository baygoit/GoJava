package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dto.PaymentDto;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
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
        log.info("<boolean> createPayment({}, {}, {}, {})...", name, card, amount, projectId);

        if (myValidator.validatePayer(name, card)) {
            Payment payment = new Payment(name, card, amount,  projectDao.get(projectId));
            paymentDao.add(payment);
            return true;
        }
        return false;
    }

    private PaymentDto constuctPaymentDto(Payment payment) {
        log.info("<PaymentDto> constuctPaymentDto({})...", payment);

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setUser(payment.getUser());
        paymentDto.setCard(payment.getCard());
        paymentDto.setAmount(payment.getAmount());

        paymentDto.setProject(payment.getProject());
        log.info("<PaymentDto> constuctPaymentDto({}) set projectId = {}", payment, paymentDto.getProject().getProjectId());

        return paymentDto;
    }
}
