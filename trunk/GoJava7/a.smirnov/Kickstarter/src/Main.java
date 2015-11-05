import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class Main {
	public static void main(String[] args) {
		ProjectDAO pr = new ProjectDAO();
		List<Project> projects = pr.getDataSource();
		
		
		for(Project project : projects) {
			System.out.println(project);
			System.out.println("===========================");
		}
		
		QuoteDAO qu = new QuoteDAO();
		List<Quote> quotes = qu.getDataSource();
		
		for(Quote quote : quotes) {
			System.out.println(quote);
			System.out.println("===========================");
		}
	}

}
