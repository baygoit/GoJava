package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentFileDAO extends FileDAO<Payment> implements PaymentDAO {

    public PaymentFileDAO() {
        super(Payment.class);
    }

    public PaymentFileDAO(String pathToFile) {
        super(Payment.class, pathToFile);
    }

    @Override
    public List<Payment> getByProject(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .collect(Collectors.toList());
    }
    
    @Override
    public long getSum(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .mapToLong(Payment::getSum)
                .sum();
    }

}
