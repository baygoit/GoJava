package ua.goit.web;

import static org.junit.Assert.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.mockito.*;
import ua.goit.web.model.Main;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.servlet.ModelServiceLocator;

public class dependencyTest extends Mockito {
	ApplicationContext app;

//	@Before
//	public void setUp() {
//		app = new ClassPathXmlApplicationContext("application-context.xml");
//
//	}
//
//	@Test
//	public void mainTest() {
//
//		Main main = (Main) app.getBean("main");
//		HttpServletRequest stubrequest = mock(HttpServletRequest.class);
//		HttpServletResponse stubresponse = mock(HttpServletResponse.class);
//		try {
//			main.doGet(stubrequest, stubresponse);
//		} catch (KickstarterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void serviceLocatorTest() {
//		ModelServiceLocator modelServiceLocator = (ModelServiceLocator) app
//				.getBean("modelServiceLocator");
//
//
//		Main model = (Main) modelServiceLocator.getService("main");
//		HttpServletRequest stubrequest = mock(HttpServletRequest.class);
//		HttpServletResponse stubresponse = mock(HttpServletResponse.class);
//		try {
//			model.doGet(stubrequest, stubresponse);
//		} catch (KickstarterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.err.println(model.toString());
//	}
}
