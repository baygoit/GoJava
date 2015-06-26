package bekskii.artem.basic;

import java.util.HashSet;
import java.util.Set;

public class App {
  public static void main(String[] args) {
	  Input consoleIn = new Input();
	  Lonely lonely = new Lonely();
	  consoleIn.setString();
	  System.out.println("lonely nymber:    " +lonely.findLonely(consoleIn.getInput()));
	  


  }
}