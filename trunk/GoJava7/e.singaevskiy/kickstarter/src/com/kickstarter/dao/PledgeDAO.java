package com.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.kickstarter.beans.Pledge;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.User;

public class PledgeDAO extends CommonDAO<Pledge> {

	public PledgeDAO() {
		ProjectDAO projectDAO = new ProjectDAO();
		PaymentDAO paymentDAO = new PaymentDAO();
		
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
		List<Pledge> filtered = dataSource.stream()
				.filter(pledge -> pledge.getUser().equals(user))
				.collect(Collectors.toList());
		return filtered;
	}

	public List<Pledge> getByProject(Project project) {
		List<Pledge> filtered = dataSource.stream()
				.filter(pledge -> pledge.getProject().equals(project))
				.collect(Collectors.toList());
		return filtered;
	}

	public long getSum(Project project) {
		long sum = dataSource.stream()
			    .filter(pledge -> pledge.getProject().equals(project))
			    .mapToLong(Pledge::getPledgeSum)
			    .sum();
		return sum;
	}

}
