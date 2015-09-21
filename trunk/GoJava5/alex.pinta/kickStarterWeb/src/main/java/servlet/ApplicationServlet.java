package servlet;

import dao.LoadingData;
import model.Category;
import model.Project;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.08.15
 * Time: 23:55
 * @version: 1.0
 */

@Deprecated
public class ApplicationServlet extends HttpServlet {
    private final String FOLDER_JSP = "WEB-INF/jsp/";
    private LoadingData daoJDBC;

    @Override
    public void init() throws ServletException {
        super.init();
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring/Spring.xml");

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        daoJDBC = (LoadingData)context.getBean("hibernateSource");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        String actionString = getAction(req);
        if (actionString.equals("")){
            req.setAttribute("listOfCategories", daoJDBC.getCategoryList());
            requestDispatcher = req.getRequestDispatcher(FOLDER_JSP + "start.jsp");

        } else if (actionString.equals("category")){
            Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
            Category category = daoJDBC.getCategoryByID(categoryId);
            req.setAttribute("category", category);
            req.setAttribute("listOfProjects", daoJDBC.getListOfProjectByCategoryID(categoryId));
            requestDispatcher = req.getRequestDispatcher(FOLDER_JSP + "category.jsp");
        } else if (actionString.equals("project") || actionString.equals("question")){
            Category category = daoJDBC.getCategoryByID(Integer.parseInt(req.getParameter("categoryId")));
            Project project = daoJDBC.getProjectByID(Integer.parseInt(req.getParameter("projectId")));
            daoJDBC.updateDemoLinkOfProject(project);
            daoJDBC.updateHistoryOfProject(project);
            daoJDBC.updateUserQuestionAnswerOfProject(project);

            req.setAttribute("category", category);
            req.setAttribute("project", project);
            if (req.getParameter("askQuestion") == null){
                req.setAttribute("modePrepareQuestion", Boolean.FALSE);
                if (req.getParameter("userQuestion_SubmitCancel")!=null && req.getParameter("userQuestion_SubmitCancel").equals("Submit")){
                    daoJDBC.setQuestionAnswerOfProject(project, req.getParameter("userQuestion_description"), req.getParameter("userQuestion_userName"));
                }
            } else {
                req.setAttribute("modePrepareQuestion", Boolean.TRUE);
            }

            requestDispatcher = req.getRequestDispatcher(FOLDER_JSP + "project.jsp");
        } else if (actionString.equals("investation") && req.getParameter("approve")!=null){
            Category category = daoJDBC.getCategoryByID(Integer.parseInt(req.getParameter("categoryId")));
            Project project = daoJDBC.getProjectByID(Integer.parseInt(req.getParameter("projectId")));
            daoJDBC.updateTermsOfProject(project);
            req.setAttribute("project", project);
            req.setAttribute("category", category);
            requestDispatcher = req.getRequestDispatcher(FOLDER_JSP + "invest.jsp");
        } else if (actionString.equals("term")){
            Project project = daoJDBC.getProjectByID(Integer.parseInt(req.getParameter("projectId")));
            Category category = daoJDBC.getCategoryByID(Integer.parseInt(req.getParameter("categoryId")));
            daoJDBC.updateDemoLinkOfProject(project);
            daoJDBC.updateHistoryOfProject(project);
            daoJDBC.updateUserQuestionAnswerOfProject(project);

            req.setAttribute("category", category);
            req.setAttribute("project", project);
            if (req.getParameter("ChooseOfInvest").equals("InvestAgree")){
                if (req.getParameter("choice").equals("userAmount")){
                    daoJDBC.setInfoOfProject(project, "balancedAmount", project.getBalancedAmount() + Integer.parseInt(req.getParameter("userValue")));
                } else {
                   Project.Terms term = daoJDBC.getTermByID(project.getId(), Integer.parseInt(req.getParameter("choice")));
                    daoJDBC.setInfoOfProject(project, "balancedAmount", project.getBalancedAmount() + term.getPayAmount());
                }
                requestDispatcher = req.getRequestDispatcher(FOLDER_JSP + "project.jsp");
            } else {

                requestDispatcher = req.getRequestDispatcher(FOLDER_JSP + "project.jsp");
            }
        }
        if (requestDispatcher != null){ //&& req.getMethod().equals("GET")) {
            requestDispatcher.forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest request){
        String path = request.getRequestURI();
        return path.substring(request.getContextPath().length()+1,
                path.length());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
