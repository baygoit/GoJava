package ua.com.goit.java5.dm.kickstarter.mvc.model;

import java.util.List;
import ua.com.goit.java5.dm.kickstarter.model.Category;
import ua.com.goit.java5.dm.kickstarter.model.Quote;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/12/15
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageModel {

    private Quote quote;
    private List<Category> categoryList;

    public MainPageModel() {
    }

    public MainPageModel(Quote quote, List<Category> categoryList) {
        this.quote = quote;
        this.categoryList = categoryList;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainPageModel that = (MainPageModel) o;

        if (categoryList != null ? !categoryList.equals(that.categoryList) : that.categoryList != null) return false;
        if (quote != null ? !quote.equals(that.quote) : that.quote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quote != null ? quote.hashCode() : 0;
        result = 31 * result + (categoryList != null ? categoryList.hashCode() : 0);
        return result;
    }
}
