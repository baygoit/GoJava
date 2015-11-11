package com.azuiev.servlet;


import com.azuiev.model.Apartment;
import com.azuiev.model.City;
import com.azuiev.model.User;
import com.azuiev.service.CityService;
import com.azuiev.service.ApartmentService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class SearchServlet extends HttpServlet {
    List<City> city = new ArrayList<City>();

    @Override
    public void init() throws ServletException {

        CityService cityService = new CityService();
        city = cityService.getAll();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {

            request.getRequestDispatcher(context.getInitParameter("path") + "/login.jsp").forward(request, response);
            return;
        }
        String query = request.getQueryString();
        {
            request.setAttribute("city", city);

            if (query != null) {
                HashMap<String, String> map = parseQuery(query);
                ApartmentService apartmentService = new ApartmentService();
                List<Apartment> apartment = null;
                apartment = ApartmentService.getByCity(Long.parseLong(map.get("cityid")));
                request.setAttribute("apartment", apartment);
            }

            request.getRequestDispatcher(context.getInitParameter("path") + request.getServletPath() + ".jsp").forward(request, response);
        }

    }

    private HashMap<String, String> parseQuery(String query) {
        String[] split = query.split("&");
        String[] keyvalue;
        HashMap<String, String> map = new HashMap<>();
        for (String s : split) {
            keyvalue = s.split("=");
            map.put(keyvalue[0], keyvalue[1]);
        }
        return map;
    }
}
