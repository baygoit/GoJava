package ua.com.goit.gojava7.salivon.dao;

import ua.com.goit.gojava7.salivon.beans.Payment;

public interface PaymentDao {

    public void savePayment(Payment payment);

    public int getTotal(int idProject);
}
