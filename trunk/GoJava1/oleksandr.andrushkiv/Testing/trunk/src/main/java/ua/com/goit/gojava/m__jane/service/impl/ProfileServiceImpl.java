package ua.com.goit.gojava.m__jane.service.impl;

import java.util.List;




import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.DataBuilder;
import ua.com.goit.gojava.m__jane.service.ProfileService;


public class ProfileServiceImpl implements ProfileService {

	private List<Profile> profileList;
	
	public ProfileServiceImpl() throws JAXBException{
		loadProfileList();
	}
	
	private void loadProfileList() throws JAXBException {
		profileList = DataBuilder.getInstance().getDataLoader().getProfileList();
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
