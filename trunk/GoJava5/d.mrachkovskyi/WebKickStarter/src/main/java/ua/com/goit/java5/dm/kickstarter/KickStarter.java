package ua.com.goit.java5.dm.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua.com.goit.java5.dm.kickstarter.dao.CategoryDao;
import ua.com.goit.java5.dm.kickstarter.dao.QuoteDao;
import ua.com.goit.java5.dm.kickstarter.model.Category;
import ua.com.goit.java5.dm.kickstarter.model.Quote;
import ua.com.goit.java5.dm.kickstarter.mvc.controller.MainPageController;
import ua.com.goit.java5.dm.kickstarter.servlet.DoGetServlet;
import ua.com.goit.java5.dm.kickstarter.servlet.MainPageServlet;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/12/15
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class KickStarter {

    private Map<String, DoGetServlet> doGetRequestMapping = new HashMap<>();

    public void init() {
        QuoteDao quoteDao = new QuoteDao();
        quoteDao.setQuotes(createQuotes());

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.setCategoryList(createCategories());

        MainPageController mainPageController = new MainPageController();
        mainPageController.setQuoteDao(quoteDao);
        mainPageController.setCategoryDao(categoryDao);
        mainPageController.setView("main.jsp");

        MainPageServlet mainPageServlet = new MainPageServlet();
        mainPageServlet.setMainPageController(mainPageController);

        doGetRequestMapping.put("/", mainPageServlet);
    }

    public Map<String, DoGetServlet> getDoGetRequestMapping() {
        return doGetRequestMapping;
    }

    private List<Quote> createQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("If you want to achieve greatness stop asking for permission.", "Anonymous"));
        quotes.add(new Quote("Things work out best for those who make the best of how things work out.", "John Wooden"));
        quotes.add(new Quote("To live a creative life, we must lose our fear of being wrong.", "Anonymous"));
        quotes.add(new Quote("If you are not willing to risk the usual you will have to settle for the ordinary.", "Jim Rohn"));
        quotes.add(new Quote("ITrust because you are willing to accept the risk, not because it's safe or certain.", "Anonymous"));
        return quotes;
    }

    private List<Category> createCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Sport"));
        categoryList.add(new Category("Movie"));
        categoryList.add(new Category("Games"));
        return categoryList;
    }

}
