package kickstarter.dao;

import kickstarter.dao.databaseServices.DBprojectService;
import kickstarter.dao.interfaces.iCategoryService;
import kickstarter.dao.interfaces.iCommentService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iProjectService;
import kickstarter.dao.interfaces.iQuoteService;
import kickstarter.dao.interfaces.iUserService;


public class DAO implements iDAO {
	private iProjectService iProjectService;
	private iCategoryService iCategoryService;
	private iQuoteService iQuoteService;
	private iCommentService iCommentService;
	private iUserService iUserService;
	@Override
	public iUserService getUserService() {
		return iUserService;
	}
	@Override
	public void setUserService(iUserService iUserService) {
		this.iUserService = iUserService;
	}

	@Override
	public void setProjectService(iProjectService iProjectService) {
		this.iProjectService = iProjectService;
	}

	@Override
	public void setCategoryService(iCategoryService categoryService) {
		this.iCategoryService = categoryService;
	}

	@Override
	public void setCommentService(iCommentService commentService) {
		this.iCommentService = commentService;
	}

	@Override
	public iProjectService getProjectService() {
		return iProjectService;
	}

	@Override
	public iCategoryService getCategoryService() {
		return iCategoryService;
	}

	@Override
	public iCommentService getCommentService() {
		return iCommentService;
	}

	@Override
	public void setQuoteService(iQuoteService iQuoteService) {
		this.iQuoteService = iQuoteService;
	}

	@Override
	public iQuoteService getQuoteService() {
		return iQuoteService;
	}

	@Override
	public String getName() {
		if(iProjectService instanceof DBprojectService){
			return "database";
		}
		return "memory";
	}
}
