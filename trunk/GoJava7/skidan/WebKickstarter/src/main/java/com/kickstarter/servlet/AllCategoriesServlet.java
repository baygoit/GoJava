package com.kickstarter.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.kickstarter.dao.interfaces.CategoryDaoImpl;
import com.kickstarter.dao.interfaces.ProjectDaoImpl;
import com.kickstarter.dao.interfaces.QuoteDaoImpl;
import com.kickstarter.dao.interfaces.PaymentDaoImpl;
import com.kickstarter.model.Category;
import com.kickstarter.model.Quote;

@WebServlet("/AllCategoriesServlet")
public class AllCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	CategoryDaoImpl categoryDao;

	@Autowired
	QuoteDaoImpl quoteDao;

	@Autowired
	PaymentDaoImpl paymentDao;

	@Autowired
	ProjectDaoImpl projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote quote = quoteDao.get();
		List<Category> categoryList = categoryDao.getAll();
//		List<Integer> topProjectsId = paymentDao.getTopProjects();
//		List<Project> projectList = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			Project project = new Project();
//			project = projectDao.getOne(topProjectsId.get(i));
//			project.setGainedSum(paymentDao.getAll(topProjectsId.get(i)));
//			projectList.add(project);
//		}
//		request.setAttribute("projectList", projectList);
		request.setAttribute("quote", quote);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/WEB-INF/AllCategories.jsp").forward(request, response);

	}

}
