package ua.com.goit.gojava.m__jane.model;

public class Question {

	private int id;
	
	private String content;
	
	private QuestionCategory questionCategory;
	
	private Profile profile;
	/**
	 * if openQuestion==false then question has many variants of
	 * answers(a,b,c.... ), else only one (text the expected response)
	 */
	private boolean openQuestion;

	public Question() {

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}


	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}


	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public boolean isOpenQuestion() {
		return openQuestion;
	}


	public void setOpenQuestion(boolean openQuestion) {
		this.openQuestion = openQuestion;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("Question [id=").append(id)
				.append(", content=").append(content)
				.append(", questionCategory=").append(questionCategory.getName())
				.append(", profile=").append(profile.getName())
				.append(", openQuestion=").append(openQuestion)
				.append("]").toString();
	}
}
