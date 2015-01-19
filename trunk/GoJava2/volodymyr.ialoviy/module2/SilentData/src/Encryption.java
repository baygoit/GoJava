import java.util.Arrays;


public class Encryption {

	public static Message encryption(Message message) {
		// TODO Auto-generated method stub
		String strings = String.valueOf(message);
		String[] string = strings.split(" ");
		
		for (int i = 0; i < string.length; i++){
			string[i] = new StringBuffer(string[i]).reverse().toString();
			}
		
		message = (Message) Arrays.asList(string);
		
		System.out.println(Arrays.asList(string));
		
		return message;
	}

}
