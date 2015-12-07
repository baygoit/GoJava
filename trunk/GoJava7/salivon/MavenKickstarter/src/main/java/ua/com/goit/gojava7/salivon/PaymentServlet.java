package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProject = (int) request.getSession().getAttribute("idProject");
        Payment payment = new Payment(idProject);
        String namePayer = request.getParameter("name");
        long numberCard = Long.parseLong(request.getParameter("card"));
        int total = Integer.parseInt(request.getParameter("total"));
        payment.setNamePayer(namePayer);
        payment.setNumberCard(numberCard);
        payment.setTotal(total);
        savePayment(payment);
        response.sendRedirect("project");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void savePayment(Payment payment) {
        DataType dType = (DataType) getServletContext().getAttribute("mode");
        PaymentDao pDao = DaoFactory.getPaymentDao(dType);
        pDao.savePayment(payment);
    }

}
