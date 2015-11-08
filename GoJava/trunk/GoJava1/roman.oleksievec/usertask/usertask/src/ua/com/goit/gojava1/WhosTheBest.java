package ua.com.goit.gojava1;

//WHY WhosTheBest extends Players?!!!!!  GOOGLE:Inheritance (object-oriented programming)
public class WhosTheBest extends Players{

public static void main(String[] args) {
  
  //Why "run" or why "WhosTheBest"?
	WhosTheBest run = new WhosTheBest();
	run.addPlayers(bestPlayers);
	run.findPlayer();
	run.showList();
	
	    }

}

