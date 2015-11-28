package dao;

import model.User;

import java.util.List;

public abstract class AbstractUserDao {

    public abstract void create(User user);

    public abstract List<User> readAll();

    public abstract User readByEmail(String email);


}
