package kickstarter_gk;

import java.util.Scanner;


public class Scaner {
    private Scanner scanner;
    
    public Scaner() {
    	scanner = new Scanner(System.in);
    	    }
    
    public int Input () {
      return scanner.nextInt();
       }
    
    protected void finalize() throws Throwable {
    	scanner.close();
    }
    
}


