package ua.nenya.alex.users;

import java.util.List;

import ua.nenya.alex.project.Category;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class Admin {
	private static final String LOGIN = "admin";
	private static final String PASSWORD = "admin";
	private static final String CATEGORIES_FILE_NAME = "categories.txt";
	private static final String ADMIN_FUNCTIONS_FILE_NAME = "adminFunctions.txt";

	public Admin() {
	}

	public String getLogin() {
		return LOGIN;
	}

	public String getPassword() {
		return PASSWORD;
	}

	public boolean isAdmin(String login, String password) {
		String loginPassword = login + password;
		return loginPassword.equals(LOGIN + PASSWORD);
	}

	public boolean enterLikeAdmin(Category category, IO io,
			User user, ListUtilits listUtil) {
		boolean b = false;

		List<String> list = io.read(ADMIN_FUNCTIONS_FILE_NAME);
		int index;
		while ((index = listUtil.choseIndexFromList(list, io)) != 0) {
			String function = list.get(index-1);
			List<Category> categoryList = category.getCategoriesList();
			if (function.equals("add category")) {
				addCategory(category, io, categoryList);
				b = true;
			}
			if (function.equals("show all categories")) {
				showAllCategories(categoryList, io);
				io.writeEmpty();
				b = true;
			}
			if (function.equals("show users")) {
				showUsers(io, user);
				io.writeEmpty();
				b = true;
			}
		}
		return b;

	}

	private void showAllCategories(List<Category> categoryList, IO io) {
		for(int i = 1; i < categoryList.size(); i++){
			io.write(categoryList.get(i).toString());
		}
		io.writeEmpty();
	}

	private void addCategory(Category category, IO io,
			List<Category> categoryList) {

		showAllCategories(categoryList, io);
		io.write("Enter new category: ");
		String newCategory = io.readConsole();
		if (!isCategoryExists(io, categoryList, newCategory)) {
			Category newCategor = new Category(newCategory);
			io.writeFile(CATEGORIES_FILE_NAME, newCategory);
			category.getCategoriesList().add(newCategor);
		}
	}

	private boolean isCategoryExists(IO io, List<Category> categoryList,
			String newCategory) {
		for (Category it : categoryList) {
			if (it.getName().equals(newCategory)) {
				io.writeln("Category " + newCategory + " exists");
				io.writeEmpty();
				return true;
			}
		}
		return false;
	}
	
	private void showUsers(IO io, User user) {
		List<User> usersList = user.getUsersList();
		for (int i = 0; i < usersList.size(); i++) {
				io.writeln("User login:	"+usersList.get(i).getLogin()+
						",	user email:	" +usersList.get(i).getEmail());
			
		}
	}

}
