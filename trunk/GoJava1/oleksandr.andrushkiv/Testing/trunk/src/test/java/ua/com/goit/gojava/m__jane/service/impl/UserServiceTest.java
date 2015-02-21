package ua.com.goit.gojava.m__jane.service.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.service.UserService;

public class UserServiceTest {

	public static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserServiceImpl();	
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
