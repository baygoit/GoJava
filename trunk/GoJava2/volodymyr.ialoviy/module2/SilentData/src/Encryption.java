
public class Encryption {

	private String stringMessage;

	public Message encryption(Message message) {
		String strings = message.getMessage();
		String[] string = strings.split(" ");
		
		stringMessage = "";
		for (int i = 0; i < string.length; i++){
			stringMessage += new StringBuffer(string[i]).reverse().toString() + " ";
			}

		message.message = stringMessage;
		
		return message;
	}

}
