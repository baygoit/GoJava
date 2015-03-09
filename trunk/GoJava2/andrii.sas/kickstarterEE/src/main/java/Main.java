import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.model.Category;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		CategoriesDAO caegoriesDAO = context.getBean(CategoriesDAO.class);
		List<Category> categories = caegoriesDAO.getCategories();
		
		System.out.println(categories.toString());
	}
}
