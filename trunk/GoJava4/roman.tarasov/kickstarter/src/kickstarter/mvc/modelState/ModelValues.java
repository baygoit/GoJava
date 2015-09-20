package kickstarter.mvc.modelState;

public class ModelValues {
	private int[] intValues;
	private String[] strValues;
	private int intSelectedProject;
	private String strSelectedProject;
	private String amountToInvest;
	private String resultOfBankOperation;
	private int intSelectedCategory;

	public String getAmountToInvest() {
		return amountToInvest;
	}

	public void setAmountToInvest(String amountToInvest) {
		this.amountToInvest = amountToInvest;
	}

	public void setResultOfBankOperation(String resultOfBankOperation) {
		this.resultOfBankOperation = resultOfBankOperation;
	}

	public int getIntSelectedProject() {
		return intSelectedProject;
	}

	public void setIntSelectedCategory(int intSelectedCategory) {
		this.intSelectedCategory = intSelectedCategory;
	}

	public String getStrSelectedProject() {
		return strSelectedProject;
	}

	public void setStrSelectedProject(String strSelectedProject) {
		this.strSelectedProject = strSelectedProject;
	}

	public int[] getIntValues() {
		return intValues;
	}

	public void setIntValues(int[] intValues) {
		this.intValues = intValues;
	}

	public String[] getStrValues() {
		return strValues;
	}

	public void setStrValues(String[] strValues) {
		this.strValues = strValues;
	}

	public void setIntSelectedProject(int intSelectedProject) {
		this.intSelectedProject = intSelectedProject;
	}

	public String getResultOfBankOperation() {
		return resultOfBankOperation;
	}

	public int getIntSelectedCategory() {
		return intSelectedCategory;
	}

}
