package mainkick;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import model.Categories;
import model.CategoriesFromDB;
import model.Projects;
import model.ProjectsFromDB;

import org.junit.Test;

import presenter.KickstarterS;
import view.InputsConsole;
import view.OutputConsole;
import view.View;

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
	
	Categories categories = new CategoriesFromDB();
	Projects projects = new ProjectsFromDB();
	View view = new View(new FakeOutputConsole());
	
	@Test
    public void testKickstarterS(){
		FakeInputsConsole fake = new FakeInputsConsole("1", "0", "0", "-3", "po", "1", "333", "5", "3", "555", "0", "p", "popo", "1", "1111222233334444", "14", "999");

		KickstarterS kickstarter = new KickstarterS(fake, categories, projects, view);

		kickstarter.kickstarter();

		assertEquals("1 name1\n2 name2\n3 name3", view.getOut().getMessages().get(1));
		assertEquals("Choice Category Number: ", view.getOut().getMessages().get(2));
		assertEquals("Your chosen category: name1, containing the following projects: ", view.getOut().getMessages().get(3));

		assertEquals("Choice Project Number or 222 for exit to Category: ", view.getOut().getMessages().get(5));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(6));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(7));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(8));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(9));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(11));
		assertEquals("Your chosen category: name1, containing the following projects: ", view.getOut().getMessages().get(12));

		assertEquals("Choice Project Number or 222 for exit to Category: ", view.getOut().getMessages().get(14));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(15));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(17));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", view.getOut().getMessages().get(18));
		assertEquals("Enter your name:", view.getOut().getMessages().get(19));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(20));
		assertEquals("Enter your credit card number:", view.getOut().getMessages().get(21));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(22));
		assertEquals("Enter the amount of donations:", view.getOut().getMessages().get(23));
		assertEquals("Thank you  for your generous (14) contribution.", view.getOut().getMessages().get(24));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(26));

		assertEquals(27, view.getOut().getMessages().size());
	}
	
	@Test
    public void testAddQuestion(){
		FakeInputsConsole fake = new FakeInputsConsole("1", "1", "666", "ytyt rtrt", "999");
		KickstarterS kickstarter = new KickstarterS(fake, categories, projects, view);

		kickstarter.kickstarter();
		
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(7));
		assertEquals("Enter your question:", view.getOut().getMessages().get(8));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(10));
		
		assertEquals(11, view.getOut().getMessages().size());
	}
	
	@Test
    public void testPayment(){
		FakeInputsConsole fake = new FakeInputsConsole("1", "1", "555", "0", "name", "1111222233334444", "54", "555", "1", "name", "1111222233334444", "555", "2", "name", "1111222233334444", "555", "3", "name", "1111222233334444", "999");
		KickstarterS kickstarter = new KickstarterS(fake, categories, projects, view);

		kickstarter.kickstarter();
		
		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(7));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", view.getOut().getMessages().get(8));
		assertEquals("Enter your name:", view.getOut().getMessages().get(9));
		assertEquals("Enter your credit card number:", view.getOut().getMessages().get(10));
		assertEquals("Enter the amount of donations:", view.getOut().getMessages().get(11));
		assertEquals("Thank you  for your generous (54) contribution.", view.getOut().getMessages().get(12));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(14));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", view.getOut().getMessages().get(15));
		assertEquals("Enter your name:", view.getOut().getMessages().get(16));
		assertEquals("Enter your credit card number:", view.getOut().getMessages().get(17));
		assertEquals("Thank you  for your generous (1) contribution.", view.getOut().getMessages().get(18));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(20));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", view.getOut().getMessages().get(21));
		assertEquals("Enter your name:", view.getOut().getMessages().get(22));
		assertEquals("Enter your credit card number:", view.getOut().getMessages().get(23));
		assertEquals("Thank you  for your generous (2) contribution.", view.getOut().getMessages().get(24));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(26));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", view.getOut().getMessages().get(27));
		assertEquals("Enter your name:", view.getOut().getMessages().get(28));
		assertEquals("Enter your credit card number:", view.getOut().getMessages().get(29));
		assertEquals("Thank you  for your generous (3) contribution.", view.getOut().getMessages().get(30));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(32));
		
		assertEquals(33, view.getOut().getMessages().size());
	}
	
	@Test
    public void testBug(){
		FakeInputsConsole fake = new FakeInputsConsole("0", "1", "1", "2", "555", "0", "name", "1111222233334444", "op", "-3", "2", "8", "999");
		KickstarterS kickstarter = new KickstarterS(fake, categories, projects, view);

		kickstarter.kickstarter();
		
		assertEquals("1 name1\n2 name2\n3 name3", view.getOut().getMessages().get(1));
		assertEquals("Choice Category Number: ", view.getOut().getMessages().get(2));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(3));
		assertEquals("Your chosen category: name1, containing the following projects: ", view.getOut().getMessages().get(4));

		assertEquals("Choice Project Number or 222 for exit to Category: ", view.getOut().getMessages().get(6));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(8));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(9));
		assertEquals("\"0\" - No thanks, I just want to help the project. \"1\" - 1$ = OUR UNDYING LOVE \"2\" - 10$ = HEY… NICE SHIRT \"3\" - 40$ = KICKSTARTER EXCLUSIVE", view.getOut().getMessages().get(10));
		assertEquals("Enter your name:", view.getOut().getMessages().get(11));
		assertEquals("Enter your credit card number:", view.getOut().getMessages().get(12));
		assertEquals("Enter the amount of donations:", view.getOut().getMessages().get(13));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(14));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(15));
		assertEquals("Thank you  for your generous (2) contribution.", view.getOut().getMessages().get(16));

		assertEquals("Choice 333 for exit to Project list.\nChoice 555 to invest in the project:Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 666:", view.getOut().getMessages().get(18));
		assertEquals("You have entered an incorrect value or a null value, check the value you entered and try again", view.getOut().getMessages().get(19));
	
		assertEquals(20, view.getOut().getMessages().size());
	}
}
