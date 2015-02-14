package mainkick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestKickstarterS {
	class FakeInputsConsole extends InputsConsole{
		private List<String> strings;
		
		public FakeInputsConsole(String... strings){
			this.strings = new ArrayList<String>(Arrays.asList(strings));
		}

		@Override
		public String enter(){
			return strings.remove(0);
		}
	}
	
	class FakeOutputConsole extends OutputConsole{
		private List<String> messages = new LinkedList<String>(); 

		@Override
		public void print(String message) {
            messages.add(message); 
	    }
	
		@Override
	    public List<String> getMessages() {
	            return messages;
	    }
	}
	
	@Test//(expected = IndexOutOfBoundsException.class)//FileNotFoundException
    public void testKickstarterS1(){

//		InputChecker check = new InputChecker(new FakeInputsConsole("1", "1", "333"), new FakeOutputConsole());
//    	Output out = new FakeOutputConsole();
//    	Categories categories = new Categories();
//    	Projects projects = new Projects();
//		
//    	KickstarterS kickstarter = new KickstarterS(check, out, categories, projects);
//
//		
//		System.out.println(1);
//		System.out.println(1);
//		System.out.println(1);
//		
////		kickstarter.kickstarter();
//		
//		System.out.println("===1");
//		
//		System.out.println(check.getOut().getMessages().toString());
//		System.out.println("===2");
////		System.out.println(kickstarter.getOut().getMessages().get(0).toString());
//		System.out.println(3);
//		System.out.println(check.getOut().getMessages().get(0).toString());
//		System.out.println(4);
//		System.out.println(check.getOut().getMessages().get(2).toString());
//		System.out.println(5);

		
//		assertEquals("This number does not exist, please try again", check.getOut().getMessages().get(0).toString());
		

	}
}
