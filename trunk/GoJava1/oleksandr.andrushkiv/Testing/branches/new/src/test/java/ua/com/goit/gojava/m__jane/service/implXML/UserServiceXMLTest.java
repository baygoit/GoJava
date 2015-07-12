package ua.com.goit.gojava.m__jane.service.implXML;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.service.UserService;
import ua.com.goit.gojava.m__jane.service.implXML.UserServiceImplXML;

public class UserServiceXMLTest {

	public static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserServiceImplXML();	
	}

	@Test
	public void testCheckUser() {
		User u1 = userService.checkUser("user2", "2");
		assertNotNull(u1);
		
		User u2 = userService.checkUser("user2", "22");
		assertNull(u2);
		
		User u3 = userService.checkUser("user22", "22");
		assertNull(u3);
	}

}
