package ua.com.goit.gojava.alejnikovi.medsystem;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import ua.com.goit.gojava.alejnikovi.medsystem.dao.SpecializationsDAO;

/**
 * Servlet implementation class CreateNew
 */
@WebServlet("/CreateNew")
public class SpecializationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecializationsServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newSpecializationName = request.getParameter("createSpecialization");
		try {
			SpecializationsDAO spd = new SpecializationsDAO();
			Specialization spec = new Specialization();
			spec.setName(newSpecializationName);
			spd.persist(spec);
			//Specialization.createNewSpecialisation(newSpecializationName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*int id = Integer.getInteger(request.getParameter("deleteSpecialization"));
		try {
			SpecializationsDAO spd = new SpecializationsDAO();
			spd.deleteById(id);
			//Specialization.createNewSpecialisation(newSpecializationName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	response.sendRedirect("index.jsp");
		
	}

}
