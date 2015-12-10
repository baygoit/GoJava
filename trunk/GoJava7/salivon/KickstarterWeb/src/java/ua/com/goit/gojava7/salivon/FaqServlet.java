package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;
import ua.com.goit.gojava7.salivon.dao.FaqDao;

@WebServlet(name = "FaqServlet", urlPatterns = {"/faq"})
public class FaqServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveFaq(request);
        response.sendRedirect("project");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void saveFaq(HttpServletRequest request) {
        String contextFaq = request.getParameter("faq");
        DataType dataType = (DataType) getServletContext().getAttribute("mode");
        FaqDao fDao = DaoFactory.getFaqDao(dataType);
        int idProject = Integer.parseInt(request.getParameter("id"));
        Faq faq = new Faq(idProject, contextFaq);
        fDao.saveFaq(faq);
    }
}
