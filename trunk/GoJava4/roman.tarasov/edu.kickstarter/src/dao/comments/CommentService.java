package dao.comments;

import java.util.List;
import dao.pool.KickstarterException;

public interface CommentService {

	List<ProjectComment> getCommentsByProjectID(int projectID)
			throws KickstarterException;
}
