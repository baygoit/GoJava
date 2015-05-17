package kickstarter.mvc;

public interface ModelPageInterface {
	void setPrintParameter(String parameter);

	String getCommentOfOptions();

	void setCommentOfoptions(String commentOfOptions);

	String getPrintParameter();

	void setOptions(String[] options);

	String[] getOptions();
}
