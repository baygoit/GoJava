package ua.com.goit.gojava7.kickstarter.datasource.contract;

import ua.com.goit.gojava7.kickstarter.domain.User;

public interface UserDAO extends DataSource<User>{

	User getByEmail(String email);
    
}
