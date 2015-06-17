package dao.comments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.pool.KickstarterException;

public interface CommentService {

	List<ProjectComment> getCommentsByProjectID(int projectID) throws KickstarterException;

	Map<Integer, ArrayList<ProjectComment>> getAll();

}
