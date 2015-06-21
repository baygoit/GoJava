package tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.*;

import servlet.Main;

public class test_servlet extends Mockito {

	@Test
	public void testDoProcess() throws IOException, ServletException {
		/*
		HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
		HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
		HttpSession stubHttpSession = mock(HttpSession.class);
		Main stubMain = mock(Main.class);
		when(stubHttpServletRequest.getParameter("")).thenReturn(
				"");
		when(stubHttpServletRequest.getParameter("")).thenReturn(
				"");
		when(stubHttpServletRequest.getRequestURI()).thenReturn("");
		when(stubHttpServletRequest.getSession()).thenReturn(stubHttpSession);
		when(stubHttpSession.getAttribute("")).thenReturn("");
		when(stubMain.getAction(stubHttpServletRequest)).thenReturn("");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(stubHttpServletResponse.getWriter()).thenReturn(pw);

		Main sampleServlet = new Main();
		sampleServlet
				.doProcess(stubHttpServletRequest, stubHttpServletResponse);
		String result = sw.getBuffer().toString().trim();
		System.out.println(stubHttpSession.getAttribute(""));
		System.out.println(result);
		TestCase.assertEquals(result, new String(""));
		*/
	}
}