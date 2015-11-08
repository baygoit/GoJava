



import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.*;
import org.junit.Test;

import beans.DetailedProject;
import dao.pool.KickstarterException;
import dao.project.DefaultProjectServiceImpl;
import dao.project.Project;

public class test_detailed_projectDaoTest extends Mockito {

	@Test
	public void testTest() {
		Project project = new Project();
		DetailedProject projectDao = new DetailedProject();
		project.setID(5);
		HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
		HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
		HttpSession stubHttpSession = mock(HttpSession.class);
		
		
		//DefaultProjectServiceImpl defPs=new DefaultProjectServiceImpl();
		when(stubHttpServletRequest.getSession()).thenReturn(stubHttpSession);
			
		when(stubHttpSession.getAttribute("detailedProject")).thenReturn(
				project);
		
		try {
			projectDao.doGet(stubHttpServletRequest, stubHttpServletResponse);
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
