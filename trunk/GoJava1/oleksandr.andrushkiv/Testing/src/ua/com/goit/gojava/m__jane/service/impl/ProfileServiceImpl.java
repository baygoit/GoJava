package ua.com.goit.gojava.m__jane.service.impl;

import java.util.List;

import ua.com.goit.gojava.m__jane.dao.ProfileDao;
import ua.com.goit.gojava.m__jane.dao.impl.ProfileDaoImpl;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.service.ProfileService;

public class ProfileServiceImpl implements ProfileService{

private ProfileDao profileDao;		
	
	public ProfileServiceImpl() {
		profileDao = new ProfileDaoImpl();
	}

	@Override
	public List<Profile> getProfileList() {
		
		return profileDao.getProfileList();
	}

	@Override
	public int getCount() {		
		return profileDao.getProfileList().size();
	}

	@Override
	public Profile getProfileById(int id) {
		Profile foundProfile = null;
		//TODO replaced by map
		List<Profile> listProfiles = profileDao.getProfileList();
		for (Profile profile : listProfiles) {
			if(profile.getId() == id) {
				foundProfile = profile;
				break;
			}
		}
		return foundProfile;
	}
}
