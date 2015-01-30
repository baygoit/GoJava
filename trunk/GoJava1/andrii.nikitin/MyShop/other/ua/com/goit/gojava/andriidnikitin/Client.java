package ua.com.goit.gojava.andriidnikitin;

public class Client { 
	
	private String firstName;
	
	private String secondName;
	
	private Integer id;
	
	public Client() {
	}	

	protected Client(String firstName, String secondName, Integer id) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.id = id;
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public Client setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getSecondName() {
		return secondName;
	}

	public Client setSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Client setId(Integer id) {
		this.id = id;
		return this;
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", secondName=" + secondName
				+ ", id=" + id + "]";
	}	
}