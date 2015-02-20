package ua.com.goit.gojava1.grigorius0sol.RCCreateModel;

public abstract class Model {
	
	private int id = 0;

	public int getId() {
		return id;
	}

	public void setId() {
		this.id++;
	}
	
	abstract void delete(Model model);
}
