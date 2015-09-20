package ua.com.goit.gojava.m__jane.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.impl.ProfileServiceImpl;

public class ProfileServiceTest {

	private static ProfileService profileService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		profileService = new ProfileServiceImpl();
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
		assertEquals(2, profileService.getProfileCount());
	}

	@Test
	public void testGetProfile() {
		assertEquals(new Profile(1,"Торгові питання"), profileService.getProfile(1));
	}

}
