package education.kickstarter.spring.ioc;

public class ConsolePrinter {
	private String message;
	ConsolePrinter(String message){
		this.message=message;
	}
	void print(){
		System.out.println(message);
	}
	
}
