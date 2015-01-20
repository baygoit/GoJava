package ua.com.goit.gojava.m__jane.service;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.Profile;

public interface ProfileService {
	
	public List<Profile> getProfileList();
	public int getCount();
	public Profile getProfileById(int id);

}
