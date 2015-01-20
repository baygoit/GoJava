package ua.com.goit.gojava.m__jane.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.dao.ProfileDao;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.source.InnerStorage;

public class ProfileDaoImpl implements ProfileDao {
	private final static InnerStorage STORAGE = new InnerStorage();
	
	@Override
	public List<Profile> getProfileList() {
		
		List<Profile> list = new ArrayList<>();
				
		List<String> listString = STORAGE.getProfiles();
		for (int i = 0; i < listString.size(); i++) {			
			String[] arr = listString.get(i).split(STORAGE.splitter);
			Profile p = new Profile();
				p.setId(Integer.parseInt(arr[0]));
				p.setName(arr[1]);				
				list.add(p);		
		}
		
		return list;
	}

}
