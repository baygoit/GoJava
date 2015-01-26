package ua.com.goit.gojava.alejnikovi.medsystem;

class Specialization {
	
	private String name;
		
	Specialization (String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
