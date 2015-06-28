package ua.goit.web.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MemoryCommentDaoImpl implements CommentDao{
	
	private volatile static HashMap<Integer, ArrayList<Comment>> allComments;
	private volatile static ArrayList<Comment> commentsInProject;
	private volatile static MemoryCommentDaoImpl uniqueInstance;
	
	private MemoryCommentDaoImpl() {
	}

	public static MemoryCommentDaoImpl getInstance() {
		if (uniqueInstance == null) {
			synchronized (MemoryCommentDaoImpl.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new MemoryCommentDaoImpl();
					init();
				}
			}
		}
		return uniqueInstance;
	}

	@Override
	public synchronized List<Comment> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	@Override
	public synchronized void addComment(Comment newComment)
			throws KickstarterException {

		int projectID = newComment.getProjectID();
		if (allComments.size() > 10000) {
			throw new KickstarterException(
					 "default comment service : all comments limit");
		}
		List<Comment> commentsOfProject = allComments.get(projectID);

		if (commentsOfProject != null && !commentsOfProject.isEmpty()) {
			newComment.setCommentID(searchMaxCommentID(commentsOfProject));
			commentsOfProject.add(newComment);
			return;
		}
		ArrayList<Comment> newList = new ArrayList<Comment>();
		newComment.setCommentID(1);
		newList.add(newComment);
		allComments.put(projectID, newList);
	}

	private int searchMaxCommentID(List<Comment> commentsOfProject) {

		int maxID = commentsOfProject.get(0).getCommentID();
		for (Comment comment : commentsOfProject) {
			int currentID = comment.getCommentID();
			if (currentID > maxID) {
				maxID = currentID;
			}
		}
		return maxID + 1;
	}

	static synchronized void init(){
		
			allComments = new HashMap<Integer, ArrayList<Comment>>();
			commentsInProject = new ArrayList<Comment>();
			int projectID = 8;
			Comment comment = new Comment();
			comment.setComment("What color will paint?");
			comment.setUserID(5);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);

			comment = new Comment();
			comment.setComment("Paint is Green");
			comment.setUserID(9);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);
			allComments.put(projectID, commentsInProject);

			projectID = 23;
			commentsInProject = new ArrayList<Comment>();
			comment = new Comment();
			comment.setComment("how much weight the bike?");
			comment.setUserID(9);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);

			comment = new Comment();
			comment.setComment("The weight of bike is 15 kilo");
			comment.setUserID(5);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);
			allComments.put(projectID, commentsInProject);

			projectID = 20;
			commentsInProject = new ArrayList<Comment>();
			comment = new Comment();
			comment.setComment("One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
			comment.setUserID(5);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			commentsInProject.add(comment);

			comment = new Comment();
			comment.setUserID(9);
			comment.setCommentID(1 + commentsInProject.size());
			comment.setProjectID(projectID);
			comment.setComment("Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
			commentsInProject.add(comment);
			allComments.put(projectID, commentsInProject);
		
	}

}