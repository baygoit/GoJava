package kickstarter;


public class Engine {
	private Output output = new Output();
	private Input input = new Input();
	private ProjectList prodjectList = new ProjectList();
	
	 public void run(){
		 output.quatation();
		 output.category();
		 input.choiceCategory();
		 output.oneProject();
		 input.choiceProject();
		 
		 
	 }
	
}
