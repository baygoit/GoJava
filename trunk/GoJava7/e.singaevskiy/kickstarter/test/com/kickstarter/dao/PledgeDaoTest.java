package com.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kickstarter.beans.Payment;
import com.kickstarter.beans.Pledge;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.User;
import com.kickstarter.dao.PaymentDAO;
import com.kickstarter.dao.PledgeDAO;
import com.kickstarter.dao.ProjectDAO;

public class PledgeDaoTest {

	private PledgeDAO dao;
	private Project project;
	private User user = new User("TestUser");
	
	@Before
	public void init() {
		ProjectDAO projectDAO = new ProjectDAO();
		project = projectDAO.get(0);
		PaymentDAO paymentDAO = new PaymentDAO();
		
		List<Pledge> dataSource = new ArrayList<>();
		dataSource.add(new Pledge(project, paymentDAO.get(0)));
		dataSource.add(new Pledge(project, new Payment(user, 123, 123, new Date())));
		dataSource.add(new Pledge(project, new Payment(user, 456, 456, new Date())));
		dataSource.add(new Pledge(projectDAO.get(1), paymentDAO.get(3)));
		dataSource.add(new Pledge(projectDAO.get(2), paymentDAO.get(4)));
		
		dao = new PledgeDAO(dataSource);
	}
	
	@Test
	public void getAll() {
		List<Pledge> list = dao.getAll();
		assertThat(list.isEmpty(), is(false));
	}
	
	@Test
	public void getByUser() {
		List<Pledge> list = dao.getByUser(user);
		assertThat(list.size(), is(2));
		list.forEach(pledge -> assertThat(pledge.getUser(), is(user)));
	}
	
	@Test
	public void getByProject() {
		List<Pledge> list = dao.getByProject(project);
		assertThat(list.size(), is(3));
		list.forEach(pledge -> assertThat(pledge.getProject(), is(project)));
	}

}
