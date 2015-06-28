package ua.goit.web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import ua.goit.web.model.dao.Category;
import ua.goit.web.model.dao.CategoryDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Quote;
import ua.goit.web.model.dao.QuoteDao;

@Service
public class Main extends ModelService implements IConcreteService {
	public Main(QuoteDao quoteDao, CategoryDao categoryDao) {
		this.quoteDao = quoteDao;
		this.categoryDao = categoryDao;
		super.model = this;
	}

	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
		Quote quote = quoteDao.getRandomQuote();
		request.setAttribute("quote", quote);
		List<Category> categories = null;
		categories = categoryDao.getAll();
		request.setAttribute("categories", categories);
	}

	@Override
	public String getJspName() {
		return "Main.jsp";
	}
}
