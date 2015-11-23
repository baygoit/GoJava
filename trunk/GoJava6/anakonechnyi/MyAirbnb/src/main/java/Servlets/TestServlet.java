package servlets;

import dao.ApartmentDAO;
import dao.CitiesDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
    public TestServlet() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List cityList = (new CitiesDAO()).getCities();
        request.setAttribute("cityList", cityList);
        List apartmentList = (new ApartmentDAO()).getApartments();
        request.setAttribute("apartments", apartmentList);
        request.getRequestDispatcher("WEB-INF/view/search").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List cityList = (new CitiesDAO()).getCities();
        request.setAttribute("cityList", cityList);
        List apartmentList = (new ApartmentDAO()).getApartments();
        request.setAttribute("apartments", apartmentList);
        request.getRequestDispatcher("WEB-INF/view/search").forward(request, response);
    }
}
