import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChoiceFriedSend {
	private String name;
	
	public User addReceiver(User receiver) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the user name one of your contact: ");
	    	name = reader.readLine();
	    	Check check = new Check();
	    	if (check.checkEqual(name)){//TODO !isEmpty Contact.property
	    		System.out.println("Your friend found " + name + " to your contact.");
	    		receiver.name = name;
	    	}
	    	else {
	    		System.out.println("Your friend not found to your contact-> God buy!!!");
	    	}
		return receiver;
	}

}
