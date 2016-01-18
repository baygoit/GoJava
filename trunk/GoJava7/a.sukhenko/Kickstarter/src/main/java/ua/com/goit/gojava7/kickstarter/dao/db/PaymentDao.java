package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.util.Validator;

@Repository
public class PaymentDao{
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(PaymentDao.class);

    @Autowired
    SessionFactory                                       sessionFactory;

    @Autowired
    private Validator                                    validator;

    public List<Payment> getAll() {
        logger.debug("getting all payments from db.");
        String hql = "FROM Payment Paymnt";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<Payment> results = HibernateUtil.listAndCast(query);
        if (results.isEmpty()) {
            throw new NoSuchElementException("hibernate returned 0 payments: list is empty.");
        }
        if (session.isOpen()) {
            session.close();
        }
        return results;
    }

    public List<Payment> getPaymentsByProjectId(int projectId) {
        logger.debug("Getting Payments by projectId: " + projectId);
        Session session = sessionFactory.openSession();
        String hql = "FROM Payment P WHERE P.project.id = :projectId";
        Query query = session.createQuery(hql);
        query.setParameter("projectId", projectId);
        List<Payment> results = HibernateUtil.listAndCast(query);
        if (session.isOpen()) {
            session.close();
        }
        return results;
    }
    public void add(Payment payment) {
        logger.info("Adding payment " + payment);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(payment);
        session.getTransaction().commit();

        session.close();
    }

    public boolean createPayment(String cardNumber, String cardOwner, Long amount, Project project) {
        logger.info("Creating payment: ");
        if (validator.validatePayer(cardOwner, cardNumber)) {
            Payment payment = new Payment(cardNumber, cardOwner, project, amount);
            add(payment);
            return true;
        }
        return false;
    }

}
