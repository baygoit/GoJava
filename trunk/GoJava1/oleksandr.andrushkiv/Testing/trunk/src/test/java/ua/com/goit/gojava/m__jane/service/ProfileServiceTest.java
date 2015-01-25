package ua.com.goit.gojava.m__jane.service;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.goit.gojava.m__jane.model.Profile;


public class ProfileServiceTest {

	private static ProfileService profileService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		profileService = DataBuilder.getInstance()
				.getProfileService();
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
		assertEquals(new Profile(1,"Продавець"), profileService.getProfile(1));
	}

}
