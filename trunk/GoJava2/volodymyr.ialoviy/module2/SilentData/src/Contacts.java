import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contacts {
	private String name;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void addNewContact() throws IOException {
		System.out.println("Enter the user name: ");
    	name = reader.readLine();
    	if (Check.checkEqual(name)){//TODO !isEmpty AllUser.property
    		System.out.println("Your username found -> add " + name + " to your contact? So click \"y\" or - press \"n\"");
    		String yesOrNo = reader.readLine();
    		if (yesOrNo.equals("y")){ //TODO add !isEmpty in Contacts.properties name
    			WriteToFile.writeToFile(new File("Contacts.properties"), "Login: " + name);
            }
            else{
            	System.out.println("As you know, it's your choice.");
            }
    	}
    	else {
    		System.out.println("Your username not found -> God buy!!!");
    	}
	}
	
}
