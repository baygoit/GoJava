package ua.lslayer.hackit.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ua.lslayer.hackit.UserAccount;

public class UserAccountDAO {
    private static final String PATH_TO_SAVE_FILES = "c:\\workspace\\HackIt\\";
    public static UserAccount create(String login, String password) throws JAXBException, FileNotFoundException {
    	/*
    	 * 1. Make an unique id (for this case id is String = login:password);
    	 * 2. Create file.
    	 * 3. Fill file with default data;
    	 */
    	if (UserAccountDAO.get(login, password) == null) {
    		UserAccount newAccount = new UserAccount(login, password);
    		save(newAccount);
    		return newAccount; 
    	} else return null;
    }
	
	public static void save(UserAccount newAccount) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(UserAccount.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(newAccount, new File(PATH_TO_SAVE_FILES+newAccount.getLogin()+"__"+newAccount.getPassword()+".xml"));
    }
    
    public static UserAccount get(String login, String password) throws FileNotFoundException, JAXBException {
    	File f = new File(PATH_TO_SAVE_FILES+login+"__"+password+".xml");
    	if (!f.exists()) return null;  
    	JAXBContext context = JAXBContext.newInstance(UserAccount.class);
    	Unmarshaller um = context.createUnmarshaller();
        UserAccount returnValue = (UserAccount) um.unmarshal(new FileReader(PATH_TO_SAVE_FILES+login+"__"+password+".xml"));
        returnValue.setLogin(login);
        returnValue.setPassword(password);
        return returnValue;
    }
}
