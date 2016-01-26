//package servletTest;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import static org.mockito.Matchers.anyListOf;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.kickstarter.dao.interfaces.DbCategoryDaoImpl;
//import com.kickstarter.dao.interfaces.DbProjectDaoImpl;
//import com.kickstarter.dao.interfaces.DbQuoteImpl;
//import com.kickstarter.dao.interfaces.PaymentDaoImpl;
//import com.kickstarter.model.Category;
//import com.kickstarter.model.Quote;
//import com.kickstarter.servlet.AllCategoriesServlet;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AllCategoriesServletTest {
//
//	@Mock
//	DbCategoryDaoImpl categoryDao;
//	@Mock
//	DbQuoteImpl quoteDao;
//	@Mock
//	PaymentDaoImpl paymentDao;
//	@Mock
//	DbProjectDaoImpl projectDao;
//	@InjectMocks
//	private AllCategoriesServlet categoriesServlet;
//	
//	@Test
//	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
//		Quote quote = new Quote("quote text", "quote author");
//		when(quoteDao.get()).thenReturn(quote);
//		HttpServletRequest req = mock(HttpServletRequest.class);
//		when(req.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
//		HttpServletResponse resp = mock(HttpServletResponse.class);
//
//		PrintWriter writer = mock(PrintWriter.class);
//		when(resp.getWriter()).thenReturn(writer);
//
//		categoriesServlet.doGet(req, resp);
//
//		verify(req).setAttribute("quote", quote);
////		verify(req).setAttribute(eq("categoryList"), anyListOf(Category.class));
//	}
//
//}
