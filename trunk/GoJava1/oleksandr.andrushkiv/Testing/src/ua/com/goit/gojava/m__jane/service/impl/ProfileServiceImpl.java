package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {

	private final String splitter = "`";

	private final static String[] PROFILES;
	static {
		PROFILES = new String[2];
		PROFILES[0] = "1`Торгові питання";
		PROFILES[1] = "2`Законодавство";
	}

	public ProfileServiceImpl() {

	}

	@Override
	public List<Profile> getProfileList() {

		List<Profile> list = new ArrayList<>();

		for (int i = 0; i < PROFILES.length; i++) {
			String[] arr = PROFILES[i].split(splitter);
			Profile p = new Profile();
			p.setId(Integer.parseInt(arr[0]));
			p.setName(arr[1]);
			list.add(p);
		}

		return list;
	}

	@Override
	public int getProfileCount() {
		return getProfileList().size();
	}

	@Override
	public Profile getProfile(int profileId) {
		Profile foundProfile = null;
		// TODO replaced by map
		List<Profile> listProfiles = getProfileList();
		for (Profile profile : listProfiles) {
			if (profile.getId() == profileId) {
				foundProfile = profile;
				break;
			}
		}
		return foundProfile;
	}
}
