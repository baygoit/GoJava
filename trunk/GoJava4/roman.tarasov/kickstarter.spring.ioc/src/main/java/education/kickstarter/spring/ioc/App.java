package education.kickstarter.spring.ioc;

import java.sql.SQLException;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import education.kickstarter.spring.ioc.dao.KickstarterException;
import education.kickstarter.spring.ioc.dao.iCategoryService;
import education.kickstarter.spring.ioc.model.Category;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		// StorePropertiesOfDatabase creatorProperties = new
		// StorePropertiesOfDatabase();
		// creatorProperties.store();

		ClassPathXmlApplicationContext config = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });

		iCategoryService categoryService= (iCategoryService) config.getBean("DBcategoryServiceImpl");
		try {
			List<Category> categories = categoryService.getAll();
			for(Category currentCategory:categories){
				System.out.println(currentCategory.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
