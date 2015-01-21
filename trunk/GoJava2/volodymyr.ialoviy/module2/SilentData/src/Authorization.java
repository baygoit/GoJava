import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Authorization {
	
	public User authorization(User user) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Are you registered, so click \"y\" or - press \"n\"");
	    String yesOrNo = reader.readLine();
	    if (yesOrNo.equals("n")){
	    	user = registerUser(user);

	    }
	    else{
	    	user = checkUser(user);
	    }
	    // TODO user.setAuthorYes();
	    return user;
	}
	
	public User registerUser(User user) throws IOException{
    	user.setName();
    	//TODO !isEmpty user
		user.setPass();
		System.out.println("Your name: " + user.getName());
		System.out.println("Your password: " + user.getPass());
		
		WriteToFile file = new WriteToFile();
		file.writeToFile(new File("Login.properties"), "Login: " + user.getName() + "; pass: " + user.getPass());
		file.writeToFile(new File("AllUser.properties"), "UserName: " + user.getName());
		return user;
    }
	
    public User checkUser(User user) throws IOException{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter the user name: ");
    	String name = reader.readLine();
    	Check check = new Check();
    	if (check.checkEqual(name)){
	    	user.name = name;
    		System.out.println("Your username found -> write your password: ");
    		String pass = reader.readLine();
    		if (check.checkEqual(pass)){
    			System.out.println("Welcome in Chat \"Silent Data!!!\"");
    		}
    		else{
    			System.out.println("Your password is wrong -> Good buy!!!");
    		}
    	}
    	else {
    		System.out.println("Your username not found -> Good buy!!!");
    	}
		return null;//TODO
    }

}
