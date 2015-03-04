package ua.com.goit.gojava.m__jane.service.implXML;

import java.util.List;
import javax.xml.bind.JAXBException;
import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.ProfileService;
import ua.com.goit.gojava.m__jane.utils.DataBuilder;


public class ProfileServiceImplXML implements ProfileService {

	private List<Profile> profileList;
	
	public ProfileServiceImplXML() throws TestingServiceException{
		loadProfileList();
	}
	
	private void loadProfileList() throws TestingServiceException {
		
		try {
			profileList = DataBuilder.getInstance().getDataLoader().getProfileList();
		} catch (JAXBException e) {
			throw new TestingServiceException("Can't load data!");
		}
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
