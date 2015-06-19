package com.morkva.model;

import com.morkva.entities.PaymentOption;
import com.morkva.entities.Project;

import java.util.List;

/**
 * Created by koros on 17.06.2015.
 */
public interface PaymentOptionRepository {
    List<PaymentOption> getPaymentOptionsForProject(Project project);
}
