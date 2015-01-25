package ua.com.goit.gojava.m__jane.service.impl;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.ProfileService;

@XmlRootElement(name="rootElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileServiceImpl implements ProfileService {

	@XmlElement(name = "profile")
	@XmlElementWrapper(name = "profiles")
	private List<Profile> profileList;
	
	public ProfileServiceImpl(){
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
