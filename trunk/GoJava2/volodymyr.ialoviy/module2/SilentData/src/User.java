import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
	private String name;
	private String pass;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
    public String getName() {
        return name;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setName() throws IOException {
    	System.out.println("Enter the user name: ");
        name = reader.readLine();
    }
    
    public void setPass() throws IOException {
    	System.out.println("Enter the user Password: ");
        pass = reader.readLine();
    }
    
    public void checkUser() throws IOException{
    	System.out.println("Enter the user name: ");
    	name = reader.readLine();
    	if (Check.checkEqual(name)){
    		System.out.println("Your username found -> write your password: ");
    		pass = reader.readLine();
    		if (Check.checkEqual(pass)){
    			System.out.println("Welcome in Chat \"Silent Data!!!\"");
    		}
    		else{
    			System.out.println("Your password is wrong -> God buy!!!");
    		}
    	}
    	else {
    		System.out.println("Your username not found -> God buy!!!");
    	}
    }
    
    public void registerUser(User user1) throws IOException{
    	user1.setName();
    	//TODO !isEmpty user1
		user1.setPass();
		System.out.println("Your name: " + user1.getName());
		System.out.println("Your password: " + user1.getPass());
		WriteToFile.writeToFile(new File("Login.properties"), "Login: " + user1.getName() + "; pass: " + user1.getPass());
		WriteToFile.writeToFile(new File("AllUser.properties"), "UserName: " + user1.getName());
    }
 
}
