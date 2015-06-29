package ua.goit.web.model.dao;

import java.util.List;

public class MemoryDao implements IDao {
	private MemoryCategoryDao categoryDao;
	private MemoryProjectDao projectDao;
	private MemoryQuoteDao quoteDao;
	private MemoryCommentDao commentDao;
	private MemoryUserDao userDao;

	public MemoryDao(MemoryCategoryDao categoryDao,
			MemoryProjectDao projectDao, MemoryQuoteDao quoteDao,
			MemoryCommentDao commentDao, MemoryUserDao userDao) {

		this.categoryDao = categoryDao;
		this.projectDao = projectDao;
		this.quoteDao = quoteDao;
		this.commentDao = commentDao;
		this.userDao = userDao;
	}

	@Override
	public List<Category> getAllCategories() throws KickstarterException {
		return categoryDao.getAllCategories();
	}

	@Override
	public List<Project> sortProjectsByCategoryID(int categoryID)
			throws KickstarterException {
		return projectDao.sortProjectsByCategoryID(categoryID);
	}

	@Override
	public Project getProjectById(int ID) throws KickstarterException {
		return projectDao.getProjectById(ID);
	}

	@Override
	public void updateProject(Project project) throws KickstarterException {
		projectDao.updateProject(project);
	}

	@Override
	public List<Comment> getCommentsByProjectID(int projectID)
			throws KickstarterException {
		return commentDao.getCommentsByProjectID(projectID);
	}

	@Override
	public void addComment(Comment newComment) throws KickstarterException {
		commentDao.addComment(newComment);
	}

	@Override
	public Quote getRandomQuote() throws KickstarterException {
		return quoteDao.getRandomQuote();
	}

	@Override
	public List<String> getUsersNamesByListComments(List<Comment> comments)
			throws KickstarterException {
		return userDao.getUsersNamesByListComments(comments);
	}

}
