import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesDAO;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
		
		CategoriesDAO categoriesDAO = context.getBean(CategoriesDAO.class);
		
		List<Category> categories = categoriesDAO.getCategories();
		
		System.out.println(categories.toString());
	}
}
