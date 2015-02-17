package kickstarter_gk;

import java.util.Scanner;


public class Scaner {
    private Scanner scanner = new Scanner(System.in);
    
    
    public int Input () {
    	int in =  scanner.nextInt();
    	scanner.nextLine();
    	return in;
       }
    
    public float InputFloat () {
    	
    	return scanner.nextFloat();
        
         }
    
    public String InputString () {
           return scanner.nextLine();
         }
      
    
    protected void finalize()  {
    	scanner.close();
    }
    
}


