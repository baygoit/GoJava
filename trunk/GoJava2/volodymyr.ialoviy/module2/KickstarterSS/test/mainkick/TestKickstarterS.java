package mainkick;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import model.Categories;
import model.CategoriesFromFile;
import model.Projects;

import org.junit.Test;

import presenter.KickstarterS;
import view.InputsConsole;
import view.OutputConsole;

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
	Categories categories = new CategoriesFromFile();
	Projects projects = new Projects();

	@Test
    public void testKickstarterS(){
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
		assertEquals("Thank you  for your generous (14) contribution.", kickstarter.getOut().getMessages().get(24));
		assertEquals("projectID = 3\nprojectName: Progect-3\nshortDescription: shortDescription-3\nfullDescription: fullDescription-3\nfoto: foto-3\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 24\nhowMuchRemaining = 976\nfaq = [ ]", kickstarter.getOut().getMessages().get(25));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(26));

		assertEquals(27, kickstarter.getOut().getMessages().size());
	}
	
	@Test
    public void testAddQuestion(){
		KickstarterS kickstarter = new KickstarterS(new FakeInputsConsole("1", "1", "666", "ytyt rtrt", "999"), new FakeOutputConsole(), categories, projects);

		kickstarter.kickstarter();
		
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 10\nhowMuchRemaining = 990\nfaq = [ ]", kickstarter.getOut().getMessages().get(6));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(7));
		assertEquals("Enter your question:", kickstarter.getOut().getMessages().get(8));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 10\nhowMuchRemaining = 990\nfaq = [ , ytyt rtrt]", kickstarter.getOut().getMessages().get(9));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(10));
		
		assertEquals(11, kickstarter.getOut().getMessages().size());
	}
	
	@Test
    public void testPayment(){
		KickstarterS kickstarter = new KickstarterS(new FakeInputsConsole("1", "1", "555", "0", "name", "1111222233334444", "54", "555", "1", "name", "1111222233334444", "555", "2", "name", "1111222233334444", "555", "3", "name", "1111222233334444", "999"), new FakeOutputConsole(), categories, projects);

		kickstarter.kickstarter();
		
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 10\nhowMuchRemaining = 990\nfaq = [ ]", kickstarter.getOut().getMessages().get(6));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(7));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", kickstarter.getOut().getMessages().get(8));
		assertEquals("Enter your name:", kickstarter.getOut().getMessages().get(9));
		assertEquals("Enter your credit card number:", kickstarter.getOut().getMessages().get(10));
		assertEquals("Enter the amount of donations:", kickstarter.getOut().getMessages().get(11));
		assertEquals("Thank you  for your generous (54) contribution.", kickstarter.getOut().getMessages().get(12));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 64\nhowMuchRemaining = 936\nfaq = [ ]", kickstarter.getOut().getMessages().get(13));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(14));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", kickstarter.getOut().getMessages().get(15));
		assertEquals("Enter your name:", kickstarter.getOut().getMessages().get(16));
		assertEquals("Enter your credit card number:", kickstarter.getOut().getMessages().get(17));
		assertEquals("Thank you  for your generous (1) contribution.", kickstarter.getOut().getMessages().get(18));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 65\nhowMuchRemaining = 935\nfaq = [ ]", kickstarter.getOut().getMessages().get(19));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(20));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", kickstarter.getOut().getMessages().get(21));
		assertEquals("Enter your name:", kickstarter.getOut().getMessages().get(22));
		assertEquals("Enter your credit card number:", kickstarter.getOut().getMessages().get(23));
		assertEquals("Thank you  for your generous (2) contribution.", kickstarter.getOut().getMessages().get(24));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 67\nhowMuchRemaining = 933\nfaq = [ ]", kickstarter.getOut().getMessages().get(25));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(26));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", kickstarter.getOut().getMessages().get(27));
		assertEquals("Enter your name:", kickstarter.getOut().getMessages().get(28));
		assertEquals("Enter your credit card number:", kickstarter.getOut().getMessages().get(29));
		assertEquals("Thank you  for your generous (3) contribution.", kickstarter.getOut().getMessages().get(30));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 70\nhowMuchRemaining = 930\nfaq = [ ]", kickstarter.getOut().getMessages().get(31));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(32));
		
		assertEquals(33, kickstarter.getOut().getMessages().size());
	}
	
	@Test
    public void testBug(){
		KickstarterS kickstarter = new KickstarterS(new FakeInputsConsole("0", "1", "1", "2", "555", "0", "name", "1111222233334444", "op", "-3", "2", "8", "999"), new FakeOutputConsole(), categories, projects);

		kickstarter.kickstarter();
		
		assertEquals("1 Category-1\n2 Category-2\n3 Category-3", kickstarter.getOut().getMessages().get(1));
		assertEquals("Choice Category Number: ", kickstarter.getOut().getMessages().get(2));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(3));
		assertEquals("Your chosen category: Category-1, containing the following projects: ", kickstarter.getOut().getMessages().get(4));
		assertEquals("1, Progect-1, shortDescription-1, 1000, 10\n3, Progect-3, shortDescription-3, 1000, 10\n4, Progect-4, shortDescription-4, 1000, 10", kickstarter.getOut().getMessages().get(5));
		assertEquals("Choice Project Number or 222 for exit to Category: ", kickstarter.getOut().getMessages().get(6));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 10\nhowMuchRemaining = 990\nfaq = [ ]", kickstarter.getOut().getMessages().get(7));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(8));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(9));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", kickstarter.getOut().getMessages().get(10));
		assertEquals("Enter your name:", kickstarter.getOut().getMessages().get(11));
		assertEquals("Enter your credit card number:", kickstarter.getOut().getMessages().get(12));
		assertEquals("Enter the amount of donations:", kickstarter.getOut().getMessages().get(13));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(14));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(15));
		assertEquals("Thank you  for your generous (2) contribution.", kickstarter.getOut().getMessages().get(16));
		assertEquals("projectID = 1\nprojectName: Progect-1\nshortDescription: shortDescription-1\nfullDescription: fullDescription-1\nfoto: foto-1\nlink: Link\nhowMuchNeeded = 1000\nhowMuchCollected = 12\nhowMuchRemaining = 988\nfaq = [ ]", kickstarter.getOut().getMessages().get(17));
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", kickstarter.getOut().getMessages().get(18));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", kickstarter.getOut().getMessages().get(19));
	
		assertEquals(20, kickstarter.getOut().getMessages().size());
	}
}
