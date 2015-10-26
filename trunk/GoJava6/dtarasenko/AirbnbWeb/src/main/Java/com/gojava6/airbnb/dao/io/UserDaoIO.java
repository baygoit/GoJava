package com.gojava6.airbnb.dao.io;

import com.gojava6.airbnb.dao.IUserDao;
import com.gojava6.airbnb.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserDaoIO implements IUserDao {

    public void createUser(User user) {
        int userId = getLastUserId() + 1;

        String line = userId + "," +
                user.getName() + "," +
                user.getSurname() + "," +
                user.getEmail() + "," +
                user.getUserType();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter("user.txt",true));
            outputStream.println(line);
        } catch (IOException ex) {
            System.out.println("IOException in method createUser");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void updateUser(User user) {
        int userId = user.getUserId();
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        String userType = user.getUserType();

        List<User> userList = getUserListInclDeleted();
        for (User u : userList) {
            if (u.getUserId() == userId) {
                u.setName(name);
                u.setSurname(surname);
                u.setEmail(email);
                u.setUserType(userType);
            }
        }
        cleanUserTxtFile();
        saveUsersInTxtFile(userList);
    }

    public void deleteUser(User user) {
        List<User> userList = getUserListInclDeleted();
        for (User u : userList) {
            if (u.getUserId() == user.getUserId()) {
                u.setName("Deleted");
                u.setSurname(" ");
                u.setEmail(" ");
                u.setUserType(" ");
            }
        }
        cleanUserTxtFile();
        saveUsersInTxtFile(userList);
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        List<User> userListInclDeleted = getUserListInclDeleted();
        for (User user : userListInclDeleted) {
            String name = user.getName();
            if (!name.equals("Deleted")) {
                userList.add(user);
            }
        }
        return userList;
    }

    public User getUser(Integer userId) {
        List<User> userList = getUserList();
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }



    private List<User> getUserListInclDeleted() {
        List<User> userList = new ArrayList<User>();
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("user.txt"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                int userId = Integer.valueOf(tokenizer.nextToken());
                String name = tokenizer.nextToken();
                String surname = tokenizer.nextToken();
                String email = tokenizer.nextToken();
                String userType = tokenizer.nextToken();

                User user = new User();
                user.setUserId(userId);
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setUserType(userType);

                userList.add(user);
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in method getUserListIncludingDelUsers");
            } else {
                System.out.println("IOException in method getUserListIncludingDelUsers");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("OException in method getUserListInclDelUsers while closing");
            }
        }
        return userList;
    }

    private int getLastUserId() {
        int lastUserId = 0;

        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("user.txt"));
            while (inputStream.readLine() != null) {
                lastUserId++;
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in getLastUserId method");
            } else {
                System.out.println("IOException in getLastUserId method");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IOException in getLastUserId method while inputStream closing");
            }
        }
        return lastUserId;
    }

    private void cleanUserTxtFile() {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("user.txt");
            outputStream.print("");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException in method cleanUserTxtFile");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private void saveUsersInTxtFile(List<User> userList) {
        for (User user : userList) {
            createUser(user);
        }
    }
}
