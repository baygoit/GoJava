package ua.com.goit.gojava.m__jane.model;

public class Question {
	
	private String number;
	private String content;
			
	
	public Question() {
		
	}
	
	
	public Question(String number, String content) {
		this.number = number;
		this.content = content;
	}


	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
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
        return number +". "+ content;
    }
	
	
}
