import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
	public String name;
	private String pass;
    private boolean author = false;
	
    public String getName() {
        return name;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setName() throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter the user name: ");
        name = reader.readLine();
    }
    
    public void setPass() throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter the user Password: ");
        pass = reader.readLine();
    }

	public boolean isAuthor() {
		return author;
	}

	public void setAuthor(boolean author) {
		this.author = author;
	}
	
	public void setAuthorYes(boolean author) {
		this.author = true;
	}
 
	public void setAuthorNo(boolean author) {
		this.author = false;
	}
}