package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {

	private final List<Profile> profileList = new ArrayList<Profile>() {

		private static final long serialVersionUID = 1L;

		{
			this.add(new Profile() {
				{
					this.setId(1);
					this.setName("Торгові питання");
				}
			});
			this.add(new Profile() {
				{
					this.setId(2);
					this.setName("Законодавство");
				}
			});
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
