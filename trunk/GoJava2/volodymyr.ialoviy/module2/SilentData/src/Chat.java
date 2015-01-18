import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chat {
	public static User user1 = new User();
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		System.out.println("Are you registered, so click \"y\" or - press \"n\"");
        String yesOrNo = reader.readLine();
        if (yesOrNo.equals("n")){
        	user1.registerUser(user1);
        }
        else{
        	user1.checkUser();
        }
		
        Contacts contact = new Contacts();
        contact.addNewContact();

        Search search = new Search();
        search.searchUser();
        
        Message message = new Message();
        message.addNewMessage();
        
        
    }
}
