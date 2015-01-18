import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Contacts {
	private String name;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void addNewContact() throws IOException {
		System.out.println("Enter the user name: ");
    	name = reader.readLine();
    	if (checkEqual(name)){
    		System.out.println("Your username found -> add " + name + " to your contact? So click \"y\" or - press \"n\"");
    		String yesOrNo = reader.readLine();
    		if (yesOrNo.equals("y")){ //TODO add !isEmpty in Contacts.properties name
                writeToFile(name);
            }
            else{
            	System.out.println("As you know, it's your choice.");
            }
    	}
    	else {
    		System.out.println("Your username not found -> God buy!!!");
    	}
	}
	
    public static boolean checkEqual(String userString){  
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");//TODO
        Matcher m = p.matcher(userString);  
        return m.matches();  
    }
	
    public void writeToFile(String name) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Contacts.properties", true));
        try {
        	bufferedWriter.write("Login: " + name);
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
