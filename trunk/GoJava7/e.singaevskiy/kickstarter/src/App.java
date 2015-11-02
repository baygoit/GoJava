import java.util.List;
import java.util.Scanner;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;
import com.kickstarter.dao.CategoryDAO;
import com.kickstarter.dao.CommonDAO;
import com.kickstarter.dao.ProjectDAO;
import com.kickstarter.dao.QuoteDAO;
import com.kickstarter.view.MainPage;

public class App {

	public static void main(String[] args) {
		start();
	}
	
	public static void start(){
		MainPage page = new MainPage();
		
		CommonDAO<Quote> quoteDAO = new QuoteDAO();
		List<Quote> quotes = quoteDAO.getAll();
		if (!quotes.isEmpty()) {
			page.setQuote(quotes.get(0));
		}
		
		CommonDAO<Category> categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getAll();
		page.setCategories(categories);

		page.update();
		
		Scanner sc = new Scanner(System.in);
		int categoryId = sc.nextInt();
		
		Category currentCategory = categories.get(categoryId);
		page.setCurrentCategory(currentCategory);
		
		ProjectDAO projectDAO = new ProjectDAO();
		List<Project> projects = projectDAO.getByCategory(currentCategory);
		
		page.setProjects(projects);
		
		page.update();
		sc.close();
		
	}

}
