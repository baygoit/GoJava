package dao.io;

import dao.Dao;
import model.GenderType;
import model.User;

import java.io.*;
import java.util.*;

public class UserIODao implements Dao {

    File userStorage = new File(this.getClass().getResource("/users").getFile());

    private User user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", "Miami");
    private User user2 = new User(2, "Bridget", "Raabe", GenderType.FEMALE, new Date(12011999), "br@gmail.com", "NY");


    private Map<Integer, User> users = new HashMap<>();

    private void addToList() {
        users.put(user1.getExternalCode(), user1);
        users.put(user2.getExternalCode(), user2);
    }

    @Override
    public void createAll(File file) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
        ) {
            addToList();
            for (Map.Entry<Integer, User> user : users.entrySet()) {
                writer.write(user.getValue().getExternalCode() + " | ");
                writer.write(user.getValue().getName() + " | ");
                writer.write(user.getValue().getLastName() + " | ");
                writer.write(user.getValue().getGender() + " | ");
                writer.write(user.getValue().getBirthDate() + " | ");
                writer.write(user.getValue().getEmail() + " | ");
                writer.write(user.getValue().getCity() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }
    }

    public User getUserByCode(int code) throws IOException {
        addToList();
        String line;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(userStorage))
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


    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }


}
