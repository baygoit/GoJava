package dao.user;

import java.util.List;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;

public interface UserService {
	User getUserInfo(String login, String password) throws KickstarterException;

	List<String> getUsersNamesByListComments(List<ProjectComment> comments) throws KickstarterException;
}
