package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;

@Repository
@Transactional
public class PaymentDao{
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(PaymentDao.class);

    @PersistenceContext
    private EntityManager                                manager;

    public List<Payment> getAll() {
        List<Payment> payments = manager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
        return payments;
    }

    public List<Payment> getPaymentsByProjectId(int projectId) {
        TypedQuery<Payment> query = manager.createNamedQuery("Payment.getByProjectId", Payment.class);
        List<Payment> payments = query.setParameter("projectId", projectId).getResultList();
        query.setParameter("projectId", projectId);
        return payments;
    }
    public void add(Payment payment) {
        manager.persist(payment);
    }

    public boolean createPayment(String cardNumber, String cardOwner, String amount, Project project) {
        logger.info("Creating payment: ");
        Payment payment = new Payment(cardNumber, cardOwner, project, amount);
        add(payment);
        return true;

    }

}
