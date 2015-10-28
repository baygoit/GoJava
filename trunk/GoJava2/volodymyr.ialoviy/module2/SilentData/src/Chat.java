import java.io.IOException;

public class Chat {
	public static void main(String[] args) throws IOException {
		
		User user = new User();
		Authorization userAuthor = new Authorization();
		user = userAuthor.authorization(user);
		
        Contacts contact = new Contacts();
        contact.addNewContact();

        ChoiceFriedSend choice = new ChoiceFriedSend();
        User receiver = new User();
        receiver = choice.addReceiver(receiver);
        
        Message message = new Message();
        Encryption encryption = new Encryption();
        
        for (int i = 0; i < 5; i++){
        	message.addNewMessage();
            encryption.encryption(message);
            System.out.println(user + " -- > " + message.message);
            encryption.encryption(message);
            System.out.println(user + " -- > " + message.message);
        	
            message.addNewMessage();
            encryption.encryption(message);
            System.out.println(receiver + " -- > " + message.message);
            encryption.encryption(message);
            System.out.println(receiver + " -- > " + message.message);
        }
        
        Delivery delivery = new Delivery();
        delivery.delivery(receiver, message);
        
        
        //TODO DELETE MESSAGE
        
    }
	
}
