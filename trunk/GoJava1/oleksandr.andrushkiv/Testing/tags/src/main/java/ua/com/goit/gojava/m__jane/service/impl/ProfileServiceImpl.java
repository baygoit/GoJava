package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {

	@SuppressWarnings("serial")
	private final List<Profile> profileList = new ArrayList<Profile>() {
		{
			add(new Profile(1,"Торгові питання"));
			add(new Profile(2,"Законодавство"));
		}
	};
	
	public ProfileServiceImpl() {

	}

	@Override
	public List<Profile> getProfileList() {
		return profileList;
	}

	@Override
	public int getProfileCount() {
		return profileList.size();
	}

	@Override
	public Profile getProfile(int profileId) {
		for (Profile profile : profileList) {
			if (profile.getId() == profileId) {
				return profile;
			}
		}
		return null;
	}	
}
