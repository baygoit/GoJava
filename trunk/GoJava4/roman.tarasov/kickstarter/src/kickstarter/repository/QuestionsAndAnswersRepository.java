package kickstarter.repository;

import kickstarter.entities.QuestionsAndAnswers;



public class QuestionsAndAnswersRepository {
	Storage<QuestionsAndAnswers> comments;

	public QuestionsAndAnswersRepository() {
		comments = new EntityStorage<QuestionsAndAnswers>();
		QuestionsAndAnswers comment = new QuestionsAndAnswers(23);
		comment.addComment(1, "What color will paint?");
		comment.addComment(2, "Paint is Green");
		comments.add(comment);

		comment = new QuestionsAndAnswers(4);
		comment.addComment(3, "how much weight the bike?");
		comment.addComment(2, "The weight of bike is 15 kilo");
		comments.add(comment);

	}
/*
	public Comments selectCommentsToProject(Project project) {
		if (project != null) {
			for (int index = 0; index < allComments.length(); index++) {
				if (allComments.getEntity(index).projectID == project.ID) {
					return allComments.getEntity(index);
				}
			}
		}
		return null;
	}
	*/
}
