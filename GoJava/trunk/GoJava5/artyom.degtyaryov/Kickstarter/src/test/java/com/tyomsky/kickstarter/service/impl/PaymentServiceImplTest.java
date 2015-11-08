package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Payment;
import com.tyomsky.kickstarter.domain.Project;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PaymentServiceImplTest {

    @Mock
    ProjectDAO projectDAO;

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void whenProcessPayment_thenModifyProjectAndMergeInDao() throws Exception {
        Project project = new Project(1, "project", "project desc", null);
        Payment payment = new Payment();
        payment.setProject(project);
        payment.setAmount(100);
        when(projectDAO.merge(project)).thenReturn(project);
        boolean processed = paymentService.processPayment(payment);

        ArgumentCaptor<Project> argumentCaptor = ArgumentCaptor.forClass(Project.class);
        verify(projectDAO, times(1)).merge(argumentCaptor.capture());

        Project projectToUpdate = argumentCaptor.getValue();

        assertEquals(projectToUpdate.getBalance(), 100);
        assertTrue(processed);
    }
}