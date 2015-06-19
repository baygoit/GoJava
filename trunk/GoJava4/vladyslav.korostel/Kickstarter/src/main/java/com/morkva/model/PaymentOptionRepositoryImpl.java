package com.morkva.model;

import com.morkva.entities.PaymentOption;
import com.morkva.entities.Project;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by koros on 17.06.2015.
 */
public class PaymentOptionRepositoryImpl implements PaymentOptionRepository {

    DAO<PaymentOption, Integer> paymentOptionDao;

    public PaymentOptionRepositoryImpl(DAO<PaymentOption, Integer> paymentOptionDao) {
        this.paymentOptionDao = paymentOptionDao;
    }

    @Override
    public List<PaymentOption> getPaymentOptionsForProject(Project project) {
        LinkedList<PaymentOption> result = new LinkedList<>();
        try {
            List<PaymentOption> all = paymentOptionDao.getAll();
            for (PaymentOption paymentOption : all) {
                if (paymentOption.getProject().getId().equals(project.getId())) {
                    result.add(paymentOption);
                }
            }

        } catch (PersistException e) {
            e.printStackTrace();
        }

        return result;
    }
}
