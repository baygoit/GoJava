package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.anyObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class CategoriesServletTest {

	@Mock
	private QuoteDbDao quoteDao;
	
	@Mock
	private CategoryDbDao categoryDao;
	
	@InjectMocks
	private CategoriesServlet categoriesServlet;

	@Test
	public void testInit() throws Exception {
		PowerMockito.mockStatic(SpringBeanAutowiringSupport.class);
		
		categoriesServlet.init();		
		PowerMockito.verifyStatic();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(anyObject());
	}
	
	
	
	
	

}
