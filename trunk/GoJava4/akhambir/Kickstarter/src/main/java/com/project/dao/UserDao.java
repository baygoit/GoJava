package com.project.dao;

import com.project.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDao {
  private Map<Integer, User> userList;

  public UserDao() {
    userList = new HashMap<Integer, User>();
  }

  public Collection<User> getUserList() {
    return userList.values();
  }
}
