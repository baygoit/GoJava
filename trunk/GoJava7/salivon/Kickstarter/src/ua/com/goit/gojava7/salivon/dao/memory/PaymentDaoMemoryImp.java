package ua.com.goit.gojava7.salivon.dao.memory;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;

public class PaymentDaoMemoryImp implements PaymentDao {

    @Override
    public void savePayment(Payment payment) {
        int id = payment.getIdProject();
        int total = payment.getTotal();
        List<Project> projects = StoreProjects.getProjects();
        for (Project project : projects) {
            if (id == project.getId()) {
                project.setCollectedAmount(total);
                break;
            }
        }
    }

    @Override
    public int getTotal(int idProject) {
        return 0;
    }

}
