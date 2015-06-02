package kickstarter.dao;
import kickstarter.dao.interfaces.iCategoryService;
import kickstarter.dao.interfaces.iCommentService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iProjectService;
import kickstarter.dao.interfaces.iQuoteService;


public class DAO implements iDAO {
	private iProjectService iProjectService;
	private iCategoryService categoryService;
	private iQuoteService iQuoteService;
	private iCommentService commentService;

	@Override
	public void setProjectService(iProjectService iProjectService) {
		this.iProjectService = iProjectService;
	}

	@Override
	public void setCategoryService(iCategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public void setCommentService(iCommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public iProjectService getProjectService() {
		return iProjectService;
	}

	@Override
	public iCategoryService getCategoryService() {
		return categoryService;
	}

	@Override
	public iCommentService getCommentService() {
		return commentService;
	}

	@Override
	public void setQuoteService(iQuoteService iQuoteService) {
		this.iQuoteService = iQuoteService;
	}

	@Override
	public iQuoteService getQuoteService() {
		return iQuoteService;
	}
}
