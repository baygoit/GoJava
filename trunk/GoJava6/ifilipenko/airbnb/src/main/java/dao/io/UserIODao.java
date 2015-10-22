package dao.io;

import dao.Dao;
import model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserIODao implements Dao {
    private HashMap<Integer, User> users = new HashMap<>();
    private File file = new File(this.getClass().getResource("/users").getFile());

    public void create(User newUser) throws IOException {
        int code = newUser.getExternalCode();
        users.put(code, newUser);

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
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

    public User readUser(int code) throws IOException {
        String line;
        Map<Integer, User> map = users;
        int size = map.size();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file))
        ) {
            while ((line = reader.readLine()) != null) {
                String[] token = line.split("\n");
                for (int i = 0; i < line.length(); i++) {
                    String[] user = token[i].split("\\|");
                    for (int j = 0; j < user.length; j++) {
                        user[j] = user[j].trim();
                        if (user[j].equals(Integer.toString(code))) {
                            User userNew = map.get(code);
                            return userNew;
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
