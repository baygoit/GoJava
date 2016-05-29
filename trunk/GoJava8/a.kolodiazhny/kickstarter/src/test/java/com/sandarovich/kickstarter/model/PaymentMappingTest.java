package com.sandarovich.kickstarter.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContextTest.xml"})
public class PaymentMappingTest {
    @PersistenceContext
    EntityManager em;
    private Project project;

    @Before
    public void init() {
        project = new Project();
        em.persist(project);

        Payment payment1 = new Payment();
        payment1.setCardHolder("Mr.A");
        payment1.setCardNumber("125");
        payment1.setAmount(123.0);
        payment1.setProject(project);

        Payment payment2 = new Payment();
        payment2.setCardHolder("Mr.B");
        payment2.setCardNumber("979");
        payment2.setAmount(550.0);
        payment2.setProject(project);

        em.merge(payment1);
        em.merge(payment2);
    }

    @Test
    public void testPaymentMapping() {
        TypedQuery<Payment> query = em.createNamedQuery("Payment.getPaymentsByProjectId", Payment.class);
        query.setParameter("projectId", project.getId());
        List<Payment> payments = query.getResultList();

        assertThat(payments.get(0).getCardHolder(), is("Mr.A"));
        assertThat(payments.get(0).getCardNumber(), is("125"));
        assertThat(payments.get(0).getAmount(), is(123.0));
        assertThat(payments.get(0).getProject(), is(project));

        assertThat(payments.get(1).getCardHolder(), is("Mr.B"));
        assertThat(payments.get(1).getCardNumber(), is("979"));
        assertThat(payments.get(1).getAmount(), is(550.0));
        assertThat(payments.get(1).getProject(), is(project));
    }

}
