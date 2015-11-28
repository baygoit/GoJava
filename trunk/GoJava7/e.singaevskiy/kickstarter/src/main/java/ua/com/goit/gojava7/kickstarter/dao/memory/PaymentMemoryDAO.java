package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentMemoryDAO extends MemoryDAO<Payment> implements PaymentDAO {

    public PaymentMemoryDAO(List<Payment> dataSource) {
        super(dataSource);
    }

    @Override
    public List<Payment> getByProject(int projectId) {
        return getFilteredPaymentStream(projectId).collect(Collectors.toList());
    }

    @Override
    public long getSum(int projectId) {
        return getFilteredPaymentStream(projectId).mapToLong(Payment::getSum).sum();
    }

    private Stream<Payment> getFilteredPaymentStream(int projectId) {
        return getAll().stream().filter(pledge -> pledge.getProjectId() == projectId);
    }
}
