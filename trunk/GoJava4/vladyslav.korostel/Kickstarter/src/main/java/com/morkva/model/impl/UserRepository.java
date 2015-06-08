package com.morkva.model.impl;

import com.morkva.entities.User;
import com.morkva.model.IRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vladyslav on 28.05.15.
 */
public class UserRepository implements IRepository<User> {

    List<User> users;

    public UserRepository(List<User> dataSource) {
        this.users = dataSource;
    }

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public User getById(int id) {
        if (size() == 0) {
            return null;
        } else {
            int searchResult = search(id);
            return users.get(searchResult);
        }
    }

    @Override
    public User findByName(String name) {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                result = user;
                break;
            }
        }
        return result;
    }

    @Override
    public User getByIndex(int index) {
        if (size() == 0) {
            return null;
        } else {
            return users.get(index);
        }
    }

    @Override
    public boolean add(User object) {
        if (search(object.getId()) < 0) {
            users.add(object);
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(User object) {
        if (search(object.getId()) > 0) {
            users.remove(object);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(User object) {
        int index = search(object.getId());
        if (index > 0) {
            users.set(index, object);
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return users.size();
    }

    @Override
    public List<User> getAll() {
        if (size() == 0) {
            return null;
        } else {
            return users;
        }
    }

    private int search(int id) {
        return Collections.binarySearch(users, id);
    }

    private void sort() {
        Collections.sort(users, (o1, o2) -> o1.compareTo(o2.getId()));
    }
}
