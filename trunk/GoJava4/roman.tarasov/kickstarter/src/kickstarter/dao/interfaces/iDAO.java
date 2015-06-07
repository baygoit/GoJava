package kickstarter.dao.interfaces;

public interface iDAO {
	
	void setQuoteService(iQuoteService iQuoteService);

	void setCommentService(iCommentService commentService);

	iProjectService getProjectService();

	iCategoryService getCategoryService();

	iQuoteService getQuoteService();

	iCommentService getCommentService();

	void setCategoryService(iCategoryService categoryService);

	void setProjectService(iProjectService iProjectService);

	String getName();

	iUserService getUserService();

	void setUserService(iUserService iUserService);
	

}
