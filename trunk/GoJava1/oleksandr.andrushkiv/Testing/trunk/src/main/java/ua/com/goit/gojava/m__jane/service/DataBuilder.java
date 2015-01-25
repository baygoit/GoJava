package ua.com.goit.gojava.m__jane.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava.m__jane.service.impl.ProfileServiceImpl;

public class DataBuilder {

	private static DataBuilder instance;
	private static ProfileService profileService;
	private static final File FILE = new File("src/main/resources/DataFile.xml");
	
	private DataBuilder() {
	}

	public static synchronized DataBuilder getInstance() throws JAXBException {
		if (instance == null) {
			instance = new DataBuilder();
			JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {ProfileServiceImpl.class});
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			profileService = (ProfileServiceImpl) jaxbUnmarshaller.unmarshal(FILE);			
		}
		return instance;
	}

	public ProfileService getProfileService() {
		return profileService;
	}
		
}
