package ua.goit.web.model.dao;

import java.util.List;


public interface UserDao {
	User getUserInfo(String login, String password) throws KickstarterException;

	List<String> getUsersNamesByListComments(List<Comment> comments) throws KickstarterException;
}
