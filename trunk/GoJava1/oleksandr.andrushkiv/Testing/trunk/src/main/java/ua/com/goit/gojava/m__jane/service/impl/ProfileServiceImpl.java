package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
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
	private List<Profile> profiles;
	
	
	
	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	
	@SuppressWarnings("serial")
	private final List<Profile> profileList = new ArrayList<Profile>() {
		{
			add(new Profile(1,"Торгові питання"));
			add(new Profile(2,"Законодавство"));
		}
	};
	
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
