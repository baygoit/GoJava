package ua.com.goit.gojava7.kickstarter.servlet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
@RunWith(MockitoJUnitRunner.class)
public class MainServletTest{
    @Mock
    CategoryDatabaseDao categoryDao;
    @Mock
    ProjectDatabaseDao  projectDao;
    @Mock
    QuoteDatabaseDao    quoteDao;
    @InjectMocks
    private MainServlet mainServlet;

    @Test
    @Ignore
    public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
        Quote quote = new Quote("quote text", "quote author");
        when(quoteDao.getRandomQuote()).thenReturn(quote);

        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        HttpServletResponse resp = mock(HttpServletResponse.class);

        PrintWriter writer = mock(PrintWriter.class);
        when(resp.getWriter()).thenReturn(writer);

        mainServlet.doGet(req, resp);

        verify(req).setAttribute("quote", quote);
        verify(req).setAttribute(eq("categories"), anyListOf(Category.class));
    }

}
