package ua.com.goit.belskii.artem;

public class HelloWorld {
	private String name="NoName";
	private String message="Hello,";
	
	public void setName(String newName){
		name=newName;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMessage(){
		return message;
	}
	public String sayHello(){
		return this.getMessage()+" "+this.getName()+"!"; 
	}
}
