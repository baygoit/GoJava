import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

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
    	if (checkEqual(name)){
    		System.out.println("Your username found -> write your password: ");
    		pass = reader.readLine();
    		if (checkEqual(pass)){
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
		user1.setPass();
		System.out.println("Your name: " + user1.getName());
		System.out.println("Your password: " + user1.getPass());
    	writeToFile(user1.getName(), user1.getPass());
    }
    
    public static boolean checkEqual(String userString){  
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$"); //TODO
        Matcher m = p.matcher(userString);  
        return m.matches();  
    }
    
	public void writeToFile(String name, String pass) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.properties", true));
        try {
        	bufferedWriter.write("Login: " + name + "; pass: " + pass);
            bufferedWriter.newLine();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
