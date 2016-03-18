package ua.nenya.dao.file;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDaoFileImplTest {

	@Test
	public void initUsersTest(){
		UserDaoFileImpl udfi = new UserDaoFileImpl();
		udfi.setFileName("src/test/resources/users.json");
		udfi.initUsers();
		assertNotNull(udfi.getUsers().get(0));
	}
}
