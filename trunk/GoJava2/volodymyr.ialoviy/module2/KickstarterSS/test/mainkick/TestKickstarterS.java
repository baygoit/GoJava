package mainkick;

import static org.junit.Assert.*;

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
	Categories categories = new Categories();
	Projects projects = new Projects();

	@Test
    public void testKickstarterS1(){
		KickstarterS kickstarter = new KickstarterS(new FakeInputsConsole("1", "0", "0", "-3", "po", "1", "333", "5", "3", "555", "0", "p", "popo", "1", "1111222233334444", "14", "999"), new FakeOutputConsole(), categories, projects);

		kickstarter.kickstarter();

		assertEquals("1 Category-1\n2 Category-2\n3 Category-3", kickstarter.getOut().getMessages().get(1));
		assertEquals("Choice Category Number: ", kickstarter.getOut().getMessages().get(2));
		assertEquals("Your chosen category: Category-1, containing the following projects: ", kickstarter.getOut().getMessages().get(3));
		assertEquals("1, Progect-1, shortDescription-1, 1000, 10\n3, Progect-3, shortDescription-3, 1000, 10\n4, Progect-4, shortDescription-4, 1000, 10", kickstarter.getOut().getMessages().get(4));
		assertEquals("Choice Project Number or 222 for exit to Category: ", kickstarter.getOut().getMessages().get(5));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(6));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(7));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(8));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(9));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 10\nhowMuchRemaining = 990\nfaq = [ ]", kickstarter.getOut().getMessages().get(10));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(11));
		assertEquals("Your chosen category: Category-1, containing the following projects: ", kickstarter.getOut().getMessages().get(12));
		assertEquals("1, Progect-1, shortDescription-1, 1000, 10\n3, Progect-3, shortDescription-3, 1000, 10\n4, Progect-4, shortDescription-4, 1000, 10", kickstarter.getOut().getMessages().get(13));
		assertEquals("Choice Project Number or 222 for exit to Category: ", kickstarter.getOut().getMessages().get(14));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(15));
		assertEquals("projectID = 3\nprojectName: Progect-3\nshortDescription: shortDescription-3\nfullDescription: fullDescription-3\nfoto: foto-3\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 10\nhowMuchRemaining = 990\nfaq = [ ]", kickstarter.getOut().getMessages().get(16));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(17));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", kickstarter.getOut().getMessages().get(18));
		assertEquals("Enter your name:", kickstarter.getOut().getMessages().get(19));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(20));
		assertEquals("Enter your credit card number:", kickstarter.getOut().getMessages().get(21));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(22));
		assertEquals("Enter the amount of donations:", kickstarter.getOut().getMessages().get(23));
		assertEquals("Thank you  for your generous (14) contribution. We record your card number (0", kickstarter.getOut().getMessages().get(24));
		assertEquals("projectID = 3\nprojectName: Progect-3\nshortDescription: shortDescription-3\nfullDescription: fullDescription-3\nfoto: foto-3\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 24\nhowMuchRemaining = 976\nfaq = [ ]", kickstarter.getOut().getMessages().get(25));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(26));

	}
}
