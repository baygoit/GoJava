package dao.comments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import dao.pool.KickstarterException;


public class DefaultCommentService implements CommentService{
	private volatile static DefaultCommentService uniqueInstance;
	private volatile static HashMap<Integer, ArrayList<ProjectComment>> allComments;
	private volatile static ArrayList<ProjectComment> commentsInProject;

	private DefaultCommentService() {
	}

	public static DefaultCommentService getInstance() {
		if (uniqueInstance == null) {
			synchronized (DefaultCommentService.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new DefaultCommentService();
					init();
				}
			}
		}
		return uniqueInstance;
	}

	@Override
	public synchronized List<ProjectComment> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	@Override
	public synchronized void addComment(ProjectComment newComment)
			throws KickstarterException {

		int projectID = newComment.getProjectID();
		if (allComments.size() > 10000) {
			throw new KickstarterException(
					 "default comment service : all comments limit");
		}
		List<ProjectComment> commentsOfProject = allComments.get(projectID);

		if (commentsOfProject != null && !commentsOfProject.isEmpty()) {
			newComment.setCommentID(searchMaxCommentID(commentsOfProject));
			commentsOfProject.add(newComment);
			return;
		}
		ArrayList<ProjectComment> newList = new ArrayList<ProjectComment>();
		newComment.setCommentID(1);
		newList.add(newComment);
		allComments.put(projectID, newList);
	}

	private int searchMaxCommentID(List<ProjectComment> commentsOfProject) {

		int maxID = commentsOfProject.get(0).getCommentID();
		for (ProjectComment comment : commentsOfProject) {
			int currentID = comment.getCommentID();
			if (currentID > maxID) {
				maxID = currentID;
			}
		}
		return maxID + 1;
	}

	static synchronized void init(){
		
			allComments = new HashMap<Integer, ArrayList<ProjectComment>>();
			commentsInProject = new ArrayList<ProjectComment>();
			int projectID = 8;
			ProjectComment comment = new ProjectComment();
			comment.setComment("What color will paint?");
			comment.setUserID(5);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);

			comment = new ProjectComment();
			comment.setComment("Paint is Green");
			comment.setUserID(9);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);
			allComments.put(projectID, commentsInProject);

			projectID = 23;
			commentsInProject = new ArrayList<ProjectComment>();
			comment = new ProjectComment();
			comment.setComment("how much weight the bike?");
			comment.setUserID(9);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);

			comment = new ProjectComment();
			comment.setComment("The weight of bike is 15 kilo");
			comment.setUserID(5);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);
			allComments.put(projectID, commentsInProject);

			projectID = 20;
			commentsInProject = new ArrayList<ProjectComment>();
			comment = new ProjectComment();
			comment.setComment("One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
			comment.setUserID(5);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);

			comment = new ProjectComment();
			comment.setUserID(9);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			comment.setComment("Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
			commentsInProject.add(comment);
			allComments.put(projectID, commentsInProject);
		
	}

}