package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.User;

public class PledgeDAO extends CommonDAO<Pledge> {

    public PledgeDAO() {
        CommonDAO<Project> projectDAO = new ProjectDAO();
        CommonDAO<Payment> paymentDAO = new PaymentDAO();

        dataSource.add(new Pledge(projectDAO.get(0), paymentDAO.get(0)));
        dataSource.add(new Pledge(projectDAO.get(0), paymentDAO.get(1)));
        dataSource.add(new Pledge(projectDAO.get(0), paymentDAO.get(2)));
        dataSource.add(new Pledge(projectDAO.get(1), paymentDAO.get(3)));
        dataSource.add(new Pledge(projectDAO.get(2), paymentDAO.get(4)));
        dataSource.add(new Pledge(projectDAO.get(3), paymentDAO.get(5)));
        dataSource.add(new Pledge(projectDAO.get(3), paymentDAO.get(6)));
    }

    public PledgeDAO(List<Pledge> dataSource) {
        this.dataSource = dataSource;
    }

    public List<Pledge> getByUser(User user) {
        return dataSource.stream().filter(pledge -> pledge.getUser().equals(user)).collect(Collectors.toList());
    }

    public List<Pledge> getByProject(Project project) {
        return dataSource.stream().filter(pledge -> pledge.getProject().equals(project)).collect(Collectors.toList());
    }

    public long getSum(Project project) {
        return dataSource.stream().filter(pledge -> pledge.getProject().equals(project)).mapToLong(Pledge::getPledgeSum)
                .sum();
    }

}
