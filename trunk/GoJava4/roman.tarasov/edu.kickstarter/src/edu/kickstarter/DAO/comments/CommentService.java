package edu.kickstarter.DAO.comments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.ProjectComment;

public interface CommentService {

	List<ProjectComment> getCommentsByProjectID(int projectID) throws KickstarterException;

	Map<Integer, ArrayList<ProjectComment>> getAll();

}
