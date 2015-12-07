package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

@WebServlet(name = "QuteAndCategoryServlet", urlPatterns = {""})
public class QuoteAndCategoryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String dataType = context.getInitParameter("mode");
        switch (dataType) {
            case "file":
                context.setAttribute("mode", DataType.FILE);
                break;
            case "memory":
                context.setAttribute("mode", DataType.MEMORY);
                break;
            case "db":
                context.setAttribute("mode", DataType.DB);
                break;
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataType dType = (DataType)getServletContext().getAttribute("mode");
        List<Category> categories = DaoFactory.getCategoryDao(dType).getAllCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
