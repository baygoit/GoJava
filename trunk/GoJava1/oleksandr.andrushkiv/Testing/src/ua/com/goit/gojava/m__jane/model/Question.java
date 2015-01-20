package ua.com.goit.gojava.m__jane.model;

public class Question {
	
	private int id;
	private String content;
	private QuestionCategory questionCategory;
	private Profile profile;
	/**
     * if openQuestion==false then question has many variants of answers(a,b,c.... ), else only one (text the expected response)
     */
	private boolean openQuestion;
			
	
	public Question() {
		
	}
	

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {

		this.content = content;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("Question [id=").append(id)
				.append(", content=").append(content)
				.append(", questionCategory=").append(questionCategory.getName())
				.append(", profile=").append(profile.getName()).append(", openQuestion=")
				.append(openQuestion).append("]").toString();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @return the questionCategory
	 */
	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}



	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}



	/**
	 * @return the openQuestion
	 */
	public boolean isOpenQuestion() {
		return openQuestion;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @param questionCategory the questionCategory to set
	 */
	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}



	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}



	/**
	 * @param openQuestion the openQuestion to set
	 */
	public void setOpenQuestion(boolean openQuestion) {
		this.openQuestion = openQuestion;
	}
	
	
}
