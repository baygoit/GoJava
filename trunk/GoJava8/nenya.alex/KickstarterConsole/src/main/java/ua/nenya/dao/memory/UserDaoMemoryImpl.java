package ua.nenya.dao.memory;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ua.nenya.project.User;
import ua.nenya.dao.UserDao;

public class UserDaoMemoryImpl implements UserDao{
	
	private List<User> users = new ArrayList<>();
	private File file = new File("src/main/resources/users.json");
	
	public void setFile(File file) {
		this.file = file;
	}

	private ObjectMapper mapper = new ObjectMapper();

	public List<User> getUsers() {
		return users;
	}
	

	@Override
	public void initUsers() {
		List<User> usersList = new ArrayList<>();
		User userZero = new User("a","a","a@a.ua");
		if(file.length() == 0){
			usersList.add(userZero);
			convertToJSON(usersList);
		}else{
			try {
				usersList = mapper.readValue(file, new TypeReference<List<User>>(){});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			for (User it : usersList) {
				users.add(it);
			}

	}
	
	private void convertToJSON(Object object) {
		
		 try {
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			mapper.writeValue(file, object);
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
