package com.azuiev.servlet;


import com.azuiev.dao.DaoDB;
import com.azuiev.db.AirbnbDB;
import com.azuiev.model.Apartment;
import com.azuiev.model.City;
import com.azuiev.service.CityService;
import com.azuiev.service.ApartmentService;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String query = req.getQueryString();
        {

            DaoDB db = new AirbnbDB();
            CityService cityService = new CityService();
            List<City> city = null;
            city = cityService.getAll();

            req.setAttribute("city", city);

            if (query!=null){
                HashMap<String, String> map = parseQuery(query);
                ApartmentService apartmentService = new ApartmentService();
                List<Apartment> apartment = null;
                apartment = ApartmentService.getByCity(Integer.parseInt(map.get("cityid")));
                req.setAttribute("apartment", apartment);
            }
            ServletContext context = req.getSession().getServletContext();
            // ServletContext context = getServletContext();
            req.getRequestDispatcher(context.getInitParameter("path") +req.getServletPath()+ ".jsp").forward(req, resp);
         }

    }

    private HashMap<String, String> parseQuery(String query) {
        String[] split = query.split("&");
        String[] keyvalue;
        HashMap<String,String> map = new HashMap<>();
        for (String s:split){
            keyvalue = s.split("=");
            map.put(keyvalue[0],keyvalue[1]);
        }
        return map;
    }
}
