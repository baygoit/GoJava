package belskii.artem.kickstarter.servlet;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainServletTest {
//
//	@Mock
//	HttpServletRequest request;
//	
//	@Mock
//	HttpServletResponse response;
//
//	@Mock
//	RequestDispatcher rd;
//
//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void test() throws Exception {
//
//		/*
//		 * HttpServletRequest request = mock(HttpServletRequest.class);
//		 * HttpServletResponse response = mock(HttpServletResponse.class);
//		 * HttpSession session = mock(HttpSession.class); RequestDispatcher
//		 * rd=mock(RequestDispatcher.class);
//		 */
//
//		when(request.getParameter("user")).thenReturn("abhinav");
//		when(request.getParameter("password")).thenReturn("passw0rd");
//		when(request.getParameter("rememberMe")).thenReturn("Y");
//		when(request.getRequestDispatcher("/HelloWorld.do")).thenReturn(rd);
//
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//
//		when(response.getWriter()).thenReturn(pw);
//
//		verify(rd).forward(request, response);
//
//		String result = sw.getBuffer().toString().trim();
//
//		System.out.println("Result: " + result);
//
//		assertEquals("Login successfull...", result);
//	}
//
//	@Test
//	public void testGetUserRequest(){
//		when(request.getRequestURI()).thenReturn("https://mySite/somePath");
//		
//	}
//	@Test
//	public void testDoGetHttpServletRequestHttpServletResponse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDoPostHttpServletRequestHttpServletResponse() {
//		fail("Not yet implemented");
//	}

}
