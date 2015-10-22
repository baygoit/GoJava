package dao.io;

import dao.Dao;
import model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserIODao implements Dao {
    private Map<Integer, User> users = new HashMap<>();
    MyUtil util = new MyUtil();

    public void create(User newUser) throws IOException {
        int code = newUser.getExternalCode();
        if (users.containsKey(code)) {
            users.put(code, newUser);
        }
        users.put(code, newUser);

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(util.getFile("/users")))
        ) {
            for (Map.Entry<Integer, User> user : users.entrySet()) {
                writer.write(user.getValue().getExternalCode() + " | ");
                writer.write(user.getValue().getName() + " | ");
                writer.write(user.getValue().getLastName() + " | ");
                writer.write(user.getValue().getGender() + " | ");
                writer.write(user.getValue().getBirthDate() + " | ");
                writer.write(user.getValue().getEmail() + " | ");
                writer.write(user.getValue().isHost() + " | ");
                writer.write(user.getValue().getCity() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }
    }

    public User getUserByCode(int code) throws IOException {
        String line;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(util.getFile("/users")))
        ) {
            while ((line = reader.readLine()) != null) {
                String[] token = line.split("\n");
                for (int i = 0; i < line.length(); i++) {
                    String[] user = token[i].split("\\|");
                    for (int j = 0; j < user.length; j++) {
                        user[j] = user[j].trim();
                        if (user[j].equals(Integer.toString(code))) {
                            return users.get(code);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }

        return null;
    }


}
