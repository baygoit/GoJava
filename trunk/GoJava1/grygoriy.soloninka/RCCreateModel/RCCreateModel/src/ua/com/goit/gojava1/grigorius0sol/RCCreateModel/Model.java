package ua.com.goit.gojava1.grigorius0sol.RCCreateModel;


public class Model {
	
	private int id;
	Details details;
	
	Model(){
		
		this.id++;
		this.details = new Details();
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

}
