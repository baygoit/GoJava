package ua.com.goit.java5.dm.kickstarter.mvc.controller;

import java.util.List;
import ua.com.goit.java5.dm.kickstarter.dao.CategoryDao;
import ua.com.goit.java5.dm.kickstarter.dao.QuoteDao;
import ua.com.goit.java5.dm.kickstarter.model.Category;
import ua.com.goit.java5.dm.kickstarter.model.Quote;
import ua.com.goit.java5.dm.kickstarter.mvc.ModelAndView;
import ua.com.goit.java5.dm.kickstarter.mvc.model.MainPageModel;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageController {

    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private String view;

    public ModelAndView index(){
        Quote quote = quoteDao.getQuote();
        List<Category> categoryList = categoryDao.getAllCategories();
        return new ModelAndView(new MainPageModel(quote, categoryList), view);
    }

    public void setQuoteDao(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setView(String view) {
        this.view = view;
    }
}
