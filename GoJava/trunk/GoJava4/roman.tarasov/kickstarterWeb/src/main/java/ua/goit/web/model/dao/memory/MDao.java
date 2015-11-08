package ua.goit.web.model.dao.memory;

import java.util.List;

import ua.goit.web.model.dao.Category;
import ua.goit.web.model.dao.Comment;
import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;
import ua.goit.web.model.dao.Quote;
import ua.goit.web.model.dao.User;

public class MDao implements IDao {
	private MCategoryDao categoryDao;
	private MProjectDao projectDao;
	private MQuoteDao quoteDao;
	private MCommentDao commentDao;
	private MUserDao userDao;

	public MDao(MCategoryDao categoryDao,
			MProjectDao projectDao, MQuoteDao quoteDao,
			MCommentDao commentDao, MUserDao userDao) {

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

	@Override
	public User getUserInfo(String login, String password) throws KickstarterException{
		return userDao.getUserInfo(login, password);
	}
}
