package ua.nenya.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.project.User;
import ua.nenya.dao.UserDao;

public class UserDaoFileImpl implements UserDao{
	
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	@Override
	public void initUsers() {
		File file = new File("src/main/resources/users.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			users = mapper.readValue(file, new TypeReference<List<User>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
