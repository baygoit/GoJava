package ua.nenya.dao.memory;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class UserDaoMemoryImplTest {

	@Test
	public void initUsersTest() {
		UserDaoMemoryImpl udmi = new UserDaoMemoryImpl();
		udmi.setFile(new File("src/test/resources/users.json"));
		udmi.initUsers();
		assertNotNull(udmi.getUsers().get(0));
	}

}
