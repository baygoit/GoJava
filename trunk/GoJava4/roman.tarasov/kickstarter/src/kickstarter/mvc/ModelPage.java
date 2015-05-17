package kickstarter.mvc;

public class ModelPage implements ModelPageInterface {
	String parameter;
	String[] options;
	private String commentOfOptions;
	int previousPage;
	int nextPage;
	int errorPage;
	int endPage;

	public ModelPage(int previousPage, int nextPage, int errorPage,int endPage) {
		this.previousPage=previousPage;
		this.nextPage=nextPage;
		this.errorPage=errorPage;
		this.endPage=endPage;
	}

	@Override
	public void setPrintParameter(String parameter) {
		this.parameter=parameter; 
	}

	@Override
	public String getPrintParameter() {
		return parameter;
	}

	@Override
	public void setOptions(String[] options) {
		this.options = options;

	}

	@Override
	public String[] getOptions() {
		return options;
	}

	@Override
	public String getCommentOfOptions() {
		
		return commentOfOptions;
	}

	@Override
	public void setCommentOfoptions(String commentOfOptions) {
		this.commentOfOptions=commentOfOptions;
		
	}

}
