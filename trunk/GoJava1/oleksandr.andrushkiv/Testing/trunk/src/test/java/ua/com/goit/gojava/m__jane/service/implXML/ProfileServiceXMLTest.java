package ua.com.goit.gojava.m__jane.service.implXML;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.m__jane.service.ProfileService;
import ua.com.goit.gojava.m__jane.service.implXML.ProfileServiceImplXML;

public class ProfileServiceXMLTest {

	private static ProfileService profileService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		profileService = new ProfileServiceImplXML();
	}

	@Test
	public void testProfileServiceImpl() {
		assertNotNull(profileService);
	}

	@Test
	public void testGetProfileList() {
		assertNotNull(profileService.getProfileCount());
		
		assertTrue(profileService.getProfileList() instanceof List);				
	}

	@Test
	public void testGetProfileCount() {
		assertEquals(3, profileService.getProfileCount());
	}

	@Test
	public void testGetProfile() {
				
		assertEquals(Integer.valueOf(10001), profileService.getProfile(10001).getId());
		assertEquals("Продавець", profileService.getProfile(10001).getName());
		assertEquals(2, profileService.getProfile(10001).getQuizList().size());
	}

}
