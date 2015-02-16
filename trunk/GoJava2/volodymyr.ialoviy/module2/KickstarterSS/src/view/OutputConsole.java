package view;

import java.util.LinkedList;
import java.util.List;

public class OutputConsole implements Output{
	
	private List<String> messages = new LinkedList<String>(); 

	@Override
	public void print(String messages){
		System.out.println(messages);
	}
	
    public List<String> getMessages() {
        return messages;
    }
}