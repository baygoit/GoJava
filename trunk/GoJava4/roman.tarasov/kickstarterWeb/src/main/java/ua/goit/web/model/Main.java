package ua.goit.web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import ua.goit.web.model.dao.Category;
import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Quote;

@Service
public class Main extends ModelService implements IConcreteService {
	public Main(IDao dao) {
		this.dao = dao;
		super.model = this;
	}

	private IDao dao;

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
		Quote quote = dao.getRandomQuote();
		request.setAttribute("quote", quote);
		List<Category> categories = null;
		categories = dao.getAllCategories();
		request.setAttribute("categories", categories);
	}

	@Override
	public String getJspName() {
		return "Main.jsp";
	}

	@Override
	public void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException {
	}
}
