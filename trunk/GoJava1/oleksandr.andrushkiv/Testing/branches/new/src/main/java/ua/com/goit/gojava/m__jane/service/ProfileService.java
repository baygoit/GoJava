package ua.com.goit.gojava.m__jane.service;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.Profile;

public interface ProfileService {
	
	public List<Profile> getProfileList();
	//public List<Profile> getProfileList(User user);
	public int getProfileCount();
	public Profile getProfile(int profileId);

}
