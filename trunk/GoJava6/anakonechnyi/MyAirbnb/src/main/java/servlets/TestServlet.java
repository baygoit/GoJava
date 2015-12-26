package servlets;

import dao.ApartmentDAO;
import dao.CitiesDAO;
import models.User;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
    public TestServlet() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        EntityManagerFactory factory = null;
        EntityManager manager = null;
        try {
            factory = Persistence.createEntityManagerFactory("unit");
            manager = factory.createEntityManager();
            manager.getTransaction().begin();
            manager.persist( new User("Blo", "Thisost", "bt@mail", false) );
            //manager.persist( new BlogPost("Just another blog post", "This is second blog post", new Date(), true) );
            manager.getTransaction().commit();

            //TODO: Read all entities from database using EntityManager

        } finally {
            if (manager!=null) manager.close();
            if (factory!=null) factory.close();
        }

        List cityList = (new CitiesDAO()).getCities();
        request.setAttribute("cityList", cityList);
        List apartmentList = (new ApartmentDAO()).getApartments();
        request.setAttribute("apartments", apartmentList);
        //response.sendRedirect("WEB-INF/view/search.jsp");
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
